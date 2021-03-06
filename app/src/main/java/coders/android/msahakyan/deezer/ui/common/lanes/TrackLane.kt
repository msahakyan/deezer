package coders.android.msahakyan.deezer.ui.common.lanes

import coders.android.msahakyan.deezer.ui.common.Lane
import coders.android.msahakyan.deezer.ui.common.LaneType
import coders.android.msahakyan.deezer_api.model.Track

/**
 * @author msahakyan.
 */

class TrackLane(
    val items: List<Track>? = null
) : Lane {
    override val type: LaneType
        get() = LaneType.TRACK_LANE
}