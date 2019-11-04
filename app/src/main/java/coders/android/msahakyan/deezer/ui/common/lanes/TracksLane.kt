package coders.android.msahakyan.deezer.ui.common.lanes

import coders.android.msahakyan.deezer.ui.common.Lane
import coders.android.msahakyan.deezer.ui.common.LaneType
import coders.android.msahakyan.deezer_api.model.Track

/**
 * @author msahakyan.
 */

class TracksLane(
    val lane: Lane,
    val items: List<Track>? = null
) : Lane {
    override val type: LaneType
        get() = LaneType.TRACKS_LANE
}