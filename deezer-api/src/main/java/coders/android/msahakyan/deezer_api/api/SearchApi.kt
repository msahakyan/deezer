@file:Suppress("DeferredIsResult")

package coders.android.msahakyan.deezer_api.api

import coders.android.msahakyan.deezer_api.model.Album
import coders.android.msahakyan.deezer_api.model.Artist
import coders.android.msahakyan.deezer_api.model.PageData
import coders.android.msahakyan.deezer_api.model.Playlist
import coders.android.msahakyan.deezer_api.model.Radio
import coders.android.msahakyan.deezer_api.model.Track
import coders.android.msahakyan.deezer_api.model.User
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author msahakyan.
 */

interface SearchApi {

    @GET("search/album")
    suspend fun searchAlbums(@Query("q") q: String): PageData<Album>

    @GET("search/artist")
    suspend fun searchArtists(@Query("q") q: String): PageData<Artist>

    @GET("search/playlist")
    suspend fun searchPlaylist(@Query("q") q: String): PageData<Playlist>

    @GET("search/track")
    suspend fun searchTracks(@Query("q") q: String): PageData<Track>

    @GET("search/radio")
    suspend fun searchRadios(@Query("q") q: String): PageData<Radio>

    @GET("search/user")
    suspend fun searchUsers(@Query("q") q: String): PageData<User>
}