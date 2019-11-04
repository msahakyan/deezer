package coders.android.msahakyan.deezer_api.api

import coders.android.msahakyan.deezer_api.model.Album
import coders.android.msahakyan.deezer_api.model.PageData
import coders.android.msahakyan.deezer_api.model.Track
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author msahakyan.
 */

interface AlbumApi {

    @GET("album/{id}")
    suspend fun fetchAlbumById(@Path("id") id: Int): Album?

    @GET("album/{id}/tracks")
    suspend fun fetchTracksByAlbumId(@Path("id") id: Int): PageData<Track>?
}