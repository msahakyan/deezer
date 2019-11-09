package coders.android.msahakyan.deezer.ui.common.lanes.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import coders.android.msahakyan.deezer.ui.common.Renderable
import coders.android.msahakyan.deezer.ui.common.lanes.GenreLane
import timber.log.Timber

/**
 * @author msahakyan.
 */
class GenreLaneView @JvmOverloads constructor(
    context: Context,
    attrSet: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrSet, defStyle), Renderable<GenreLane> {

    companion object {
        private const val MAX_VISIBLE_ITEMS = 10
    }

    override fun render(data: GenreLane, position: Int) {
        Timber.v("|>>>> Rendering Genre Lane")
        // TODO: Render data ... 
    }
}