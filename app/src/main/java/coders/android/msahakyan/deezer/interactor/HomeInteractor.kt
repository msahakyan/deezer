package coders.android.msahakyan.deezer.interactor

import coders.android.msahakyan.deezer_api.model.Album
import coders.android.msahakyan.deezer_api.repository.SearchRepository

/**
 * @author msahakyan.
 */
class HomeInteractor(
    private val searchRepository: SearchRepository
) {

    companion object {
        private const val DEFAULT_SEARCH_TERM = "t"
    }

    suspend fun fetchHomeLanes() {
        val albums: List<Album> = searchRepository.searchAlbums(DEFAULT_SEARCH_TERM).data
    }
}