package coders.android.msahakyan.deezer_api.model

/**
 * @author msahakyan.
 */

enum class PictureType(val value: String) {
    SMALL("small"),
    MEDIUM("medium"),
    BIG("big"),
    XL("xl")
}

fun String.buildCover(type: PictureType) = "$this?size=${type.value}"