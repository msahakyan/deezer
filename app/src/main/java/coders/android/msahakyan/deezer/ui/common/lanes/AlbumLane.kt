package coders.android.msahakyan.deezer.ui.common.lanes

import coders.android.msahakyan.deezer.ui.common.Lane
import coders.android.msahakyan.deezer.ui.common.LaneType
import coders.android.msahakyan.deezer_api.model.Album

/**
 * @author msahakyan.
 */

class AlbumLane(
    val lane: Lane,
    val items: List<Album>? = null
) : Lane {
    override val type: LaneType
        get() = LaneType.ALBUM_LANE
}