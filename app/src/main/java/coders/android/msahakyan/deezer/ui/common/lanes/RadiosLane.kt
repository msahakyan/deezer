package coders.android.msahakyan.deezer.ui.common.lanes

import android.provider.MediaStore
import coders.android.msahakyan.deezer.ui.common.Lane
import coders.android.msahakyan.deezer.ui.common.LaneType

/**
 * @author msahakyan.
 */

class RadiosLane(
    val lane: Lane,
    val items: List<MediaStore.Audio.Radio>? = null
) : Lane {
    override val type: LaneType
        get() = LaneType.RADIOS_LANE
}