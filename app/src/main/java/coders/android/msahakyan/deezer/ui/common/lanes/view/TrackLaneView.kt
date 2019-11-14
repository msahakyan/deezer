package coders.android.msahakyan.deezer.ui.common.lanes.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coders.android.msahakyan.deezer.ui.adapter.TrackAdapter
import coders.android.msahakyan.deezer.ui.common.Renderable
import coders.android.msahakyan.deezer.ui.common.lanes.TrackLane
import kotlinx.android.synthetic.main.layout_tracks_lane.view.recycler_view
import timber.log.Timber

/**
 * @author msahakyan.
 */
class TrackLaneView @JvmOverloads constructor(
    context: Context,
    attrSet: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrSet, defStyle), Renderable<TrackLane> {

    private val adapter: TrackAdapter by lazy { createAdapter() }
    private val layoutManager: RecyclerView.LayoutManager by lazy { LinearLayoutManager(context, RecyclerView.HORIZONTAL, false) }

    private fun createAdapter(): TrackAdapter =
        TrackAdapter(onItemClicked = { track, position ->
            Toast.makeText(
                context, "Track: ${track.title} on position ${position + 1} was clicked", Toast.LENGTH_SHORT
            ).show()
        })

    override fun onFinishInflate() {
        super.onFinishInflate()
        recycler_view.adapter = adapter
        recycler_view.layoutManager = layoutManager
    }

    override fun render(data: TrackLane, position: Int) {
        Timber.v("|>>>> `Rendering Track Lane`")
        adapter.setItems(data.items)
    }
}