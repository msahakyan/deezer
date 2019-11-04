package coders.android.msahakyan.deezer.ui.common.lanes

import coders.android.msahakyan.deezer.ui.common.Lane
import coders.android.msahakyan.deezer.ui.common.LaneType
import coders.android.msahakyan.deezer_api.model.Artist

/**
 * @author msahakyan.
 */

class ArtistsLane(
    val lane: Lane,
    val items: List<Artist>? = null
) : Lane {
    override val type: LaneType
        get() = LaneType.ARTISTS_LANE
}