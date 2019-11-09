package coders.android.msahakyan.deezer_api.repository

import coders.android.msahakyan.deezer_api.api.SearchApi

/**
 * @author msahakyan.
 */

class SearchRepository(
    private val searchApi: SearchApi
) {

    suspend fun searchAlbums(q: String) =
        searchApi.searchAlbums(q)

    suspend fun searchArtists(q: String) =
        searchApi.searchArtists(q)

    suspend fun searchPlaylist(q: String) =
        searchApi.searchPlaylist(q)

    suspend fun searchTracks(q: String) =
        searchApi.searchTracks(q)

    suspend fun searchRadios(q: String) =
        searchApi.searchRadios(q)

    suspend fun searchUsers(q: String) =
        searchApi.searchUsers(q)
}