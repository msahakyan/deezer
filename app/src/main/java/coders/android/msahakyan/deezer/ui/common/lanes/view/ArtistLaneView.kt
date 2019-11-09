package coders.android.msahakyan.deezer.ui.common.lanes.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import coders.android.msahakyan.deezer.ui.common.Renderable
import coders.android.msahakyan.deezer.ui.common.lanes.ArtistLane
import timber.log.Timber

/**
 * @author msahakyan.
 */
class ArtistLaneView @JvmOverloads constructor(
    context: Context,
    attrSet: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrSet, defStyle), Renderable<ArtistLane> {

    override fun render(data: ArtistLane, position: Int) {
        Timber.v("|>>>> Rendering Artists Lane")
        // TODO: Render data ... 
    }
}