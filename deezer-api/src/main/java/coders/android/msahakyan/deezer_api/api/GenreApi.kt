package coders.android.msahakyan.deezer_api.api

import coders.android.msahakyan.deezer_api.model.Artist
import coders.android.msahakyan.deezer_api.model.Genre
import coders.android.msahakyan.deezer_api.model.PageData
import coders.android.msahakyan.deezer_api.model.Podcast
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author msahakyan.
 */

interface GenreApi {

    @GET("genre")
    suspend fun fetchGenres(): PageData<Genre>

    @GET("genre/{id}")
    suspend fun fetchGenreById(@Path("id") id: Int): Genre?

    @GET("genre/{id}/artists")
    suspend fun fetchArtistsForGenre(@Path("id") id: Int): PageData<Artist>

    @GET("genre/{id}/podcasts")
    suspend fun fetchPodcastsForGenre(@Path("id") id: Int): PageData<Podcast>
}