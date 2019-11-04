package coders.android.msahakyan.deezer_api.model

/**
 * @author msahakyan.
 */

data class RadioGenre(
    val id: Int,
    val title: String,
    val radios: List<Radio>
)