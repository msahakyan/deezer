package coders.android.msahakyan.deezer.ui.common.lanes.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import coders.android.msahakyan.deezer.ui.common.Renderable
import coders.android.msahakyan.deezer.ui.common.lanes.RadioLane
import timber.log.Timber

/**
 * @author msahakyan.
 */
class RadioLaneView @JvmOverloads constructor(
    context: Context,
    attrSet: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrSet, defStyle), Renderable<RadioLane> {

    override fun render(data: RadioLane, position: Int) {
        Timber.v("|>>>> Rendering Radios Lane")
        // TODO: Render data ... 
    }
}