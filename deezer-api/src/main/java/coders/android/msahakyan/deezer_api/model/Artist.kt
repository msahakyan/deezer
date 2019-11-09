package coders.android.msahakyan.deezer_api.model

/**
 * @author msahakyan.
 */

data class Artist(
    val id: Int,
    val name: String,
    val picture: String?,
    val link: String?,
    val nb_album: Int?,
    val nb_fan: Int?,
    val tracklist: String?,
    val radio: Boolean
)