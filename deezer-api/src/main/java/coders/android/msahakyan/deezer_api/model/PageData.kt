package coders.android.msahakyan.deezer_api.model

/**
 * @author msahakyan.
 */

data class PageData<T>(
    val data: List<T>,
    val total: Int,
    val prev: String?,
    val next: String?
)