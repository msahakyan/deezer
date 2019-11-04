package coders.android.msahakyan.deezer_api.model

/**
 * @author msahakyan.
 */

data class User(
    val id: Int,
    val name: String,
    val picture: String?,
    val tracklist: String?
)