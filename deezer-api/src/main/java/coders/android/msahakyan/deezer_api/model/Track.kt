package coders.android.msahakyan.deezer_api.model

import java.util.Date

/**
 * @author msahakyan.
 */

data class Track(
    val id: Int,
    val title: String,
    val duration: Int,
    val rank: Int?,
    val release_date: Date?,
    val artist: Artist?,
    val album: Album?,
    val preview: String?
)