package coders.android.msahakyan.deezer.ui.common.lanes.view

import android.content.Context
import android.util.AttributeSet
import androidx.cardview.widget.CardView
import coders.android.msahakyan.deezer.ui.common.Renderable
import coders.android.msahakyan.deezer.ui.common.lanes.HeaderLane
import timber.log.Timber

/**
 * @author msahakyan.
 */
class HeaderLaneView @JvmOverloads constructor(
    context: Context,
    attrSet: AttributeSet? = null,
    defStyle: Int = 0
) : CardView(context, attrSet, defStyle), Renderable<HeaderLane> {

    companion object {
        private const val MAX_VISIBLE_ITEMS = 10
    }

    override fun render(data: HeaderLane, position: Int) {
        Timber.v("|>>>> Rendering Header Lane")
        // TODO: Render data ...
    }
}