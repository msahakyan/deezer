package coders.android.msahakyan.deezer.ui.common.lanes.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import coders.android.msahakyan.deezer.ui.common.Renderable
import coders.android.msahakyan.deezer.ui.common.lanes.GenresLane
import timber.log.Timber

/**
 * @author msahakyan.
 */
class GenresLaneView @JvmOverloads constructor(
    context: Context,
    attrSet: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrSet, defStyle), Renderable<GenresLane> {

    override fun render(data: GenresLane, position: Int) {
        Timber.v("|>>>> Rendering Genre Lane")
        // TODO: Render data ... 
    }
}