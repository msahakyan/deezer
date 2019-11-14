package coders.android.msahakyan.deezer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
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
import coders.android.msahakyan.deezer_api.repository.GenreRepository
import coders.android.msahakyan.deezer_api.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import timber.log.Timber
import kotlin.system.measureTimeMillis

/**
 * @author msahakyan.
 */

class HomeViewModel(
    private val searchRepository: SearchRepository,
    private val genreRepository: GenreRepository
) : ViewModel() {

    companion object {
        private const val DEFAULT_SEARCH_TERM = "rock"
        private const val ARTIST_SEARCH_TERM = "g"
        private const val HEADER_LANE_SEARCH_TERM = "Vanessa Mae"
        private const val MAX_VISIBLE_ITEMS = 20
    }

    val lanes: LiveData<List<Lane>> = liveData(Dispatchers.IO) {
        val timestamp = measureTimeMillis {
            val headerLane = HeaderLane(
                lane = object : Lane {
                    override val type = HEADER_LANE
                },
                item = searchRepository
                    .searchAlbums(HEADER_LANE_SEARCH_TERM).data[0]
            )
            val genreLane = GenreLane(
                lane = object : Lane {
                    override val type: LaneType
                        get() = GENRE_LANE
                },
                items = genreRepository
                    .fetchGenres().data
                    .take(MAX_VISIBLE_ITEMS)
            )
            val trackLane = TrackLane(
                lane = object : Lane {
                    override val type: LaneType
                        get() = TRACK_LANE
                },
                items = searchRepository
                    .searchTracks(DEFAULT_SEARCH_TERM).data
                    .take(MAX_VISIBLE_ITEMS)
            )
            val albumLane = AlbumLane(
                lane = object : Lane {
                    override val type: LaneType
                        get() = ALBUM_LANE
                },
                items = searchRepository
                    .searchAlbums(DEFAULT_SEARCH_TERM).data
                    .take(MAX_VISIBLE_ITEMS)
            )
            val artistLane = ArtistLane(
                lane = object : Lane {
                    override val type: LaneType
                        get() = ARTIST_LANE
                },
                items = searchRepository
                    .searchArtists(ARTIST_SEARCH_TERM).data
                    .filter { it.picture_big?.contains("artist//") == false }
                    .take(MAX_VISIBLE_ITEMS)
            )
            val radioLane = RadioLane(
                lane = object : Lane {
                    override val type: LaneType
                        get() = RADIO_LANE
                },
                items = searchRepository
                    .searchRadios(DEFAULT_SEARCH_TERM).data
                    .take(MAX_VISIBLE_ITEMS)
            )
            emit(listOf(headerLane, albumLane, genreLane, artistLane, trackLane, radioLane))
        }
        Timber.d("||> timestamp = $timestamp ms.")
    }
}