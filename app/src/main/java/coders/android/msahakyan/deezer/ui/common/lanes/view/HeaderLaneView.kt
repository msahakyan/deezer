package coders.android.msahakyan.deezer.ui.common.lanes.view

import android.content.Context
import android.util.AttributeSet
import android.widget.Toast
import androidx.cardview.widget.CardView
import coders.android.msahakyan.deezer.R
import coders.android.msahakyan.deezer.ui.common.Renderable
import coders.android.msahakyan.deezer.ui.common.lanes.HeaderLane
import coders.android.msahakyan.deezer.ui.loadUrl
import coders.android.msahakyan.deezer_api.model.PictureType
import coders.android.msahakyan.deezer_api.model.buildCover
import kotlinx.android.synthetic.main.layout_header_lane.view.cover_image_headerView
import kotlinx.android.synthetic.main.layout_header_lane.view.label_headerView
import kotlinx.android.synthetic.main.layout_header_lane.view.title_headerView
import timber.log.Timber

/**
 * @author msahakyan.
 */

class HeaderLaneView @JvmOverloads constructor(
    context: Context,
    attrSet: AttributeSet? = null,
    defStyle: Int = 0
) : CardView(context, attrSet, defStyle), Renderable<HeaderLane> {

    override fun render(data: HeaderLane, position: Int) {
        Timber.v("|>>>> Rendering Header Lane")
        with(data.item) {
            cover_image_headerView.loadUrl(cover?.buildCover(PictureType.XL), R.drawable.fallback_album)
            title_headerView.text = title
            label_headerView.text = label
            setOnClickListener {
                Toast.makeText(context, "Header Lane $title was clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }
}