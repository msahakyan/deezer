package coders.android.msahakyan.deezer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import coders.android.msahakyan.deezer.ui.common.Lane
import coders.android.msahakyan.deezer.ui.common.LaneType
import coders.android.msahakyan.deezer.ui.common.lanes.AlbumLane
import coders.android.msahakyan.deezer.ui.common.lanes.ArtistLane
import coders.android.msahakyan.deezer.ui.common.lanes.GenreLane
import coders.android.msahakyan.deezer.ui.common.lanes.HeaderLane
import coders.android.msahakyan.deezer.ui.common.lanes.RadioLane
import coders.android.msahakyan.deezer.ui.common.lanes.TrackLane
import coders.android.msahakyan.deezer_api.repository.GenreRepository
import coders.android.msahakyan.deezer_api.repository.SearchRepository
import kotlinx.coroutines.Dispatchers

/**
 * @author msahakyan.
 */

class HomeViewModel(
    private val searchRepository: SearchRepository,
    private val genreRepository: GenreRepository
) : ViewModel() {

    companion object {
        private const val DEFAULT_SEARCH_TERM = "t"
        private const val BEATLES_SEARCH_TERM = "Beatles"
        private const val MAX_VISIBLE_ITEMS = 20
    }

    val topAlbum: LiveData<HeaderLane> = liveData(Dispatchers.IO) {
        searchRepository
            .searchAlbums(BEATLES_SEARCH_TERM)
            .data[0]
            .also {
                emit(
                    HeaderLane(
                        lane = object : Lane {
                            override val type: LaneType
                                get() = LaneType.HEADER_LANE
                        },
                        item = it
                    )
                )
            }
    }

    val genreLane: LiveData<GenreLane> = liveData(Dispatchers.IO) {
        genreRepository.fetchGenres().data
            .take(MAX_VISIBLE_ITEMS)
            .also {
                emit(
                    GenreLane(
                        lane = object : Lane {
                            override val type: LaneType
                                get() = LaneType.GENRE_LANE
                        },
                        items = it
                    )
                )
            }
    }

    val trackLane: LiveData<TrackLane> = liveData(Dispatchers.IO) {
        searchRepository
            .searchTracks(DEFAULT_SEARCH_TERM).data
            .take(MAX_VISIBLE_ITEMS)
            .also {
                emit(
                    TrackLane(
                        lane = object : Lane {
                            override val type: LaneType
                                get() = LaneType.TRACK_LANE
                        },
                        items = it
                    )
                )
            }
    }

    val albumLane: LiveData<AlbumLane> = liveData(Dispatchers.IO) {
        searchRepository
            .searchAlbums(DEFAULT_SEARCH_TERM).data
            .take(MAX_VISIBLE_ITEMS)
            .also {
                emit(
                    AlbumLane(
                        lane = object : Lane {
                            override val type: LaneType
                                get() = LaneType.ALBUM_LANE
                        },
                        items = it
                    )
                )
            }
    }

    val artistLane: LiveData<ArtistLane> = liveData(Dispatchers.IO) {
        searchRepository
            .searchArtists(DEFAULT_SEARCH_TERM).data
            .take(MAX_VISIBLE_ITEMS)
            .also {
                emit(
                    ArtistLane(
                        lane = object : Lane {
                            override val type: LaneType
                                get() = LaneType.ARTIST_LANE
                        },
                        items = it
                    )
                )
            }
    }

    val radioLane: LiveData<RadioLane> = liveData(Dispatchers.IO) {
        searchRepository
            .searchRadios(DEFAULT_SEARCH_TERM).data
            .take(MAX_VISIBLE_ITEMS)
            .also {
                emit(
                    RadioLane(
                        lane = object : Lane {
                            override val type: LaneType
                                get() = LaneType.RADIO_LANE
                        },
                        items = it
                    )
                )
            }
    }
}