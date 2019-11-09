package coders.android.msahakyan.deezer.ui.common.lanes

import coders.android.msahakyan.deezer.ui.common.Lane
import coders.android.msahakyan.deezer.ui.common.LaneType
import coders.android.msahakyan.deezer_api.model.Genre

/**
 * @author msahakyan.
 */

class GenreLane(
    val lane: Lane,
    val items: List<Genre>? = null
) : Lane {
    override val type: LaneType
        get() = LaneType.GENRE_LANE
}