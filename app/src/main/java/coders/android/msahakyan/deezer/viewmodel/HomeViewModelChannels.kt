package coders.android.msahakyan.deezer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coders.android.msahakyan.deezer.ui.common.Lane
import coders.android.msahakyan.deezer.ui.common.LaneType
import coders.android.msahakyan.deezer.ui.common.LaneType.ALBUM_LANE
import coders.android.msahakyan.deezer.ui.common.LaneType.ARTIST_LANE
import coders.android.msahakyan.deezer.ui.common.LaneType.GENRE_LANE
import coders.android.msahakyan.deezer.ui.common.LaneType.HEADER_LANE
import coders.android.msahakyan.deezer.ui.common.LaneType.RADIO_LANE
import coders.android.msahakyan.deezer.ui.common.LaneType.TRACK_LANE
import coders.android.msahakyan.deezer.ui.common.lanes.AlbumLane
import coders.android.msahakyan.deezer.ui.common.lanes.ArtistLane
import coders.android.msahakyan.deezer.ui.common.lanes.GenreLane
import coders.android.msahakyan.deezer.ui.common.lanes.HeaderLane
import coders.android.msahakyan.deezer.ui.common.lanes.RadioLane
import coders.android.msahakyan.deezer.ui.common.lanes.TrackLane
import coders.android.msahakyan.deezer.ui.common.log
import coders.android.msahakyan.deezer_api.repository.GenreRepository
import coders.android.msahakyan.deezer_api.repository.SearchRepository
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.coroutines.coroutineContext
import kotlin.system.measureTimeMillis

/**
 * @author msahakyan.
 */

@ExperimentalCoroutinesApi
class HomeViewModelChannels(
    private val searchRepository: SearchRepository,
    private val genreRepository: GenreRepository
) : ViewModel() {

    companion object {
        private const val DEFAULT_SEARCH_TERM = "rock"
        private const val ARTIST_SEARCH_TERM = "g"
        private const val HEADER_LANE_SEARCH_TERM = "Vanessa Mae"
        private const val MAX_VISIBLE_ITEMS = 20

        private val lanesTypes = listOf(
            HEADER_LANE, ALBUM_LANE, GENRE_LANE, ARTIST_LANE, TRACK_LANE, RADIO_LANE
        )
    }

    private val result = MutableLiveData<List<Lane>>()
    val lanesLiveData: LiveData<List<Lane>>
        get() = result

    private val lanes = mutableListOf<Lane>()

    init {
        fetchLanes()
    }

    @ExperimentalCoroutinesApi
    private fun fetchLanes() = viewModelScope.launch {
        val lanesChannel = receiveChannel()

        measureTimeMillis {
            coroutineScope {
                // Let's run 6 (number of lanes) coroutines concurrently and then publish a result into lanesLiveData.
                for (i in 1..6) {
                    launch(Dispatchers.IO + CoroutineName("coroutine[$i]")) {
                        fetchLaneByType(lanesChannel)
                    }
                }
            }
        }.also { Timber.d("final timestamp: $it") }
    }

    private suspend fun fetchLaneByType(lanesChannel: ReceiveChannel<LaneType>) {
        lanesChannel.consumeEach {
            lateinit var currentLane: Lane
            measureTimeMillis {
                currentLane = fetchLane(it)
                lanes.apply {
                    add(currentLane)
                    result.postValue(this)
                }
            }.also {
                log("Fetched ${currentLane.type.name} by ${coroutineContext[CoroutineName]} in timestamp: $it")
            }
        }
    }

    private suspend fun fetchLane(type: LaneType) =
        when (type) {
            HEADER_LANE -> fetchHeaderLane()
            ALBUM_LANE -> fetchAlbumLane()
            GENRE_LANE -> fetchGenreLane()
            ARTIST_LANE -> fetchArtistLane()
            TRACK_LANE -> fetchTrackLane()
            RADIO_LANE -> fetchRadioLane()
        }.also {
            log("Fetching ${type.name} by ${coroutineContext[CoroutineName]}")
        }

    private suspend fun fetchHeaderLane() =
        HeaderLane(
            lane = object : Lane {
                override val type = HEADER_LANE
            },
            item = searchRepository
                .searchAlbums(HEADER_LANE_SEARCH_TERM).data[0]
        )

    private suspend fun fetchAlbumLane() =
        AlbumLane(
            lane = object : Lane {
                override val type: LaneType
                    get() = ALBUM_LANE
            },
            items = searchRepository
                .searchAlbums(DEFAULT_SEARCH_TERM).data
                .take(MAX_VISIBLE_ITEMS)
        )

    private suspend fun fetchGenreLane() =
        GenreLane(
            lane = object : Lane {
                override val type: LaneType
                    get() = GENRE_LANE
            },
            items = genreRepository
                .fetchGenres().data
                .take(MAX_VISIBLE_ITEMS)
        )

    private suspend fun fetchArtistLane() =
        ArtistLane(
            lane = object : Lane {
                override val type: LaneType
                    get() = ARTIST_LANE
            },
            items = searchRepository
                .searchArtists(ARTIST_SEARCH_TERM).data
                .filter { it.picture_big?.contains("artist//") == false } // avoid showing none-proper covers
                .take(MAX_VISIBLE_ITEMS)
        )

    private suspend fun fetchTrackLane() =
        TrackLane(
            lane = object : Lane {
                override val type: LaneType
                    get() = TRACK_LANE
            },
            items = searchRepository
                .searchTracks(DEFAULT_SEARCH_TERM).data
                .take(MAX_VISIBLE_ITEMS)
        )

    private suspend fun fetchRadioLane() =
        RadioLane(
            lane = object : Lane {
                override val type: LaneType
                    get() = RADIO_LANE
            },
            items = searchRepository
                .searchRadios(DEFAULT_SEARCH_TERM).data
                .take(MAX_VISIBLE_ITEMS)
        )

    private fun CoroutineScope.receiveChannel() =
        produce {
            lanesTypes.forEach {
                send(it)
            }
        }
}


