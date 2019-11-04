package coders.android.msahakyan.deezer.ui.common.lanes

import coders.android.msahakyan.deezer.ui.common.Lane
import coders.android.msahakyan.deezer.ui.common.LaneType
import coders.android.msahakyan.deezer_api.model.Artist

/**
 * @author msahakyan.
 */

class HeaderLane(
    val lane: Lane,
    val item: Artist
) : Lane {
    override val type: LaneType
        get() = LaneType.HEADER_LANE
}