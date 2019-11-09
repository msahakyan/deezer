package coders.android.msahakyan.deezer.ui.common.lanes

import android.provider.MediaStore
import coders.android.msahakyan.deezer.ui.common.Lane
import coders.android.msahakyan.deezer.ui.common.LaneType
import coders.android.msahakyan.deezer_api.model.Radio

/**
 * @author msahakyan.
 */

class RadiosLane(
    val lane: Lane,
    val items: List<Radio>? = null
) : Lane {
    override val type: LaneType
        get() = LaneType.RADIOS_LANE
}