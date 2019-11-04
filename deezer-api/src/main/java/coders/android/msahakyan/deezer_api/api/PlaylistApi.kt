package coders.android.msahakyan.deezer_api.api

import coders.android.msahakyan.deezer_api.model.PageData
import coders.android.msahakyan.deezer_api.model.Track
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author msahakyan.
 */

interface PlaylistApi {

    @GET("playlist/{id}/tracks")
    suspend fun fetchPlaylistTracksById(@Path("id") id: Int): PageData<Track>?
}