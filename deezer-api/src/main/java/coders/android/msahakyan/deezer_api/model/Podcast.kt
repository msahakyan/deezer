package coders.android.msahakyan.deezer_api.model

/**
 * @author msahakyan.
 */

data class Podcast(
    val id: Int,
    val title: String,
    val description: String?,
    val available: Boolean,
    val rating: Int,
    val fans: Int,
    val link: String,
    val share: String?,
    val picture: String
)