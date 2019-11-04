package coders.android.msahakyan.deezer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import coders.android.msahakyan.deezer_api.model.Album
import coders.android.msahakyan.deezer_api.model.PageData
import coders.android.msahakyan.deezer_api.repository.SearchRepository
import kotlinx.coroutines.Dispatchers

/**
 * @author msahakyan.
 */

class SearchViewModel(
    private val searchRepository: SearchRepository
) : ViewModel() {

    private val searchQuery: String = "eminem"

    val albums: LiveData<PageData<Album>> = liveData(Dispatchers.IO) {
        emit(searchRepository.searchAlbums(searchQuery))
    }
}