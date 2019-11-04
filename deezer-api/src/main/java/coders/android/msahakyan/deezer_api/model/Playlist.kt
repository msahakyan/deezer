package coders.android.msahakyan.deezer_api.model

/**
 * @author msahakyan.
 */

data class Playlist(
    val id: Int,
    val title: String,
    val description: String?,
    val duration: Int?,
    val rating: Int?,
    val nb_tracks: Int?,
    val fans: Int?,
    val tracks: List<Track>
)