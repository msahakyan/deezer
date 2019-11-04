package coders.android.msahakyan.deezer_api.api

import coders.android.msahakyan.deezer_api.model.Album
import coders.android.msahakyan.deezer_api.model.Artist
import coders.android.msahakyan.deezer_api.model.PageData
import coders.android.msahakyan.deezer_api.model.Playlist
import coders.android.msahakyan.deezer_api.model.Track
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author msahakyan.
 */

interface ArtistApi {

    @GET("artist/{id}/top")
    suspend fun fetchTopTracksByArtistId(@Path("id") id: Int): PageData<Track>?

    @GET("artist/{id}/albums")
    suspend fun fetchAlbumsByArtistId(@Path("id") id: Int): PageData<Album>?

    @GET("artist/{id}/related")
    suspend fun fetchRelatedArtistsByArtistId(@Path("id") id: Int): PageData<Artist>?

    @GET("artist/{id}/playlists")
    suspend fun fetchPlaylistsByArtistId(@Path("id") id: Int): PageData<Playlist>?
}