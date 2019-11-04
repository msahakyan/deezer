package coders.android.msahakyan.deezer.ui.common.lanes.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import coders.android.msahakyan.deezer.ui.common.Renderable
import coders.android.msahakyan.deezer.ui.common.lanes.RadiosLane
import timber.log.Timber

/**
 * @author msahakyan.
 */
class RadiosLaneView @JvmOverloads constructor(
    context: Context,
    attrSet: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrSet, defStyle), Renderable<RadiosLane> {

    override fun render(data: RadiosLane, position: Int) {
        Timber.v("|>>>> Rendering Radios Lane")
        // TODO: Render data ... 
    }
}