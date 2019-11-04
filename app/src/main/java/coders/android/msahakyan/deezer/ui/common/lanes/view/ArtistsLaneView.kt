package coders.android.msahakyan.deezer.ui.common.lanes.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import coders.android.msahakyan.deezer.ui.common.Renderable
import coders.android.msahakyan.deezer.ui.common.lanes.ArtistsLane
import timber.log.Timber

/**
 * @author msahakyan.
 */
class ArtistsLaneView @JvmOverloads constructor(
    context: Context,
    attrSet: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrSet, defStyle), Renderable<ArtistsLane> {

    override fun render(data: ArtistsLane, position: Int) {
        Timber.v("|>>>> Rendering Artists Lane")
        // TODO: Render data ... 
    }
}