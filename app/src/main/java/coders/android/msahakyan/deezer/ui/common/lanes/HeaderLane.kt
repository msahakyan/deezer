package coders.android.msahakyan.deezer.ui.common.lanes

import coders.android.msahakyan.deezer.ui.common.Lane
import coders.android.msahakyan.deezer.ui.common.LaneType
import coders.android.msahakyan.deezer_api.model.Album
import coders.android.msahakyan.deezer_api.model.Artist

/**
 * @author msahakyan.
 */

class HeaderLane(
    val item: Album
) : Lane {
    override val type: LaneType
        get() = LaneType.HEADER_LANE
}