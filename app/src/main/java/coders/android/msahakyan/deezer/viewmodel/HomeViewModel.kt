package coders.android.msahakyan.deezer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import coders.android.msahakyan.deezer.ui.common.Lane
import coders.android.msahakyan.deezer.ui.common.LaneType
import coders.android.msahakyan.deezer.ui.common.lanes.AlbumsLane
import coders.android.msahakyan.deezer.ui.common.lanes.ArtistsLane
import coders.android.msahakyan.deezer.ui.common.lanes.GenresLane
import coders.android.msahakyan.deezer.ui.common.lanes.HeaderLane
import coders.android.msahakyan.deezer.ui.common.lanes.RadiosLane
import coders.android.msahakyan.deezer.ui.common.lanes.TracksLane
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

    val genreLane: LiveData<GenresLane> = liveData(Dispatchers.IO) {
        genreRepository.fetchGenres().data
            .take(20)
            .also {
                emit(
                    GenresLane(
                        lane = object : Lane {
                            override val type: LaneType
                                get() = LaneType.GENRES_LANE
                        },
                        items = it
                    )
                )
            }
    }

    val trackLane: LiveData<TracksLane> = liveData(Dispatchers.IO) {
        searchRepository
            .searchTracks(DEFAULT_SEARCH_TERM).data
            .take(20)
            .also {
                emit(
                    TracksLane(
                        lane = object : Lane {
                            override val type: LaneType
                                get() = LaneType.TRACKS_LANE
                        },
                        items = it
                    )
                )
            }
    }

    val albumLane: LiveData<AlbumsLane> = liveData(Dispatchers.IO) {
        searchRepository
            .searchAlbums(DEFAULT_SEARCH_TERM).data
            .take(20)
            .also {
                emit(
                    AlbumsLane(
                        lane = object : Lane {
                            override val type: LaneType
                                get() = LaneType.ALBUMS_LANE
                        },
                        items = it
                    )
                )
            }
    }

    val artistLane: LiveData<ArtistsLane> = liveData(Dispatchers.IO) {
        searchRepository
            .searchArtists(DEFAULT_SEARCH_TERM).data
//            .take(20)
            .also {
                emit(
                    ArtistsLane(
                        lane = object : Lane {
                            override val type: LaneType
                                get() = LaneType.ARTISTS_LANE
                        },
                        items = it
                    )
                )
            }
    }

    val radioLane: LiveData<RadiosLane> = liveData(Dispatchers.IO) {
        searchRepository
            .searchRadios(DEFAULT_SEARCH_TERM).data
            .take(20)
            .also {
                emit(
                    RadiosLane(
                        lane = object : Lane {
                            override val type: LaneType
                                get() = LaneType.RADIOS_LANE
                        },
                        items = it
                    )
                )
            }
    }
}