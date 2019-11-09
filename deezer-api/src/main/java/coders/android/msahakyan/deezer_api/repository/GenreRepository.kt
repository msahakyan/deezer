package coders.android.msahakyan.deezer_api.repository

import coders.android.msahakyan.deezer_api.api.GenreApi

/**
 * @author msahakyan.
 */

class GenreRepository(
    private val genreApi: GenreApi
) {

    suspend fun fetchGenres() =
        genreApi.fetchGenres()
}