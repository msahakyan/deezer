package coders.android.msahakyan.deezer.ui.common.lanes.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coders.android.msahakyan.deezer.ui.adapter.ArtistAdapter
import coders.android.msahakyan.deezer.ui.common.Renderable
import coders.android.msahakyan.deezer.ui.common.lanes.ArtistLane
import kotlinx.android.synthetic.main.layout_artists_lane.view.recycler_view
import timber.log.Timber

/**
 * @author msahakyan.
 */
class ArtistLaneView @JvmOverloads constructor(
    context: Context,
    attrSet: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrSet, defStyle), Renderable<ArtistLane> {

    private val adapter: ArtistAdapter by lazy { createAdapter() }
    private val layoutManager: RecyclerView.LayoutManager by lazy { LinearLayoutManager(context, RecyclerView.HORIZONTAL, false) }

    private fun createAdapter(): ArtistAdapter =
        ArtistAdapter(onItemClicked = { artist, position ->
            Toast.makeText(
                context, "Artist: ${artist.name} on position ${position + 1} was clicked", Toast.LENGTH_SHORT
            ).show()
        })

    override fun onFinishInflate() {
        super.onFinishInflate()
        recycler_view.adapter = adapter
        recycler_view.layoutManager = layoutManager
    }

    override fun render(data: ArtistLane, position: Int) {
        Timber.v("|>>>> `Rendering Artist Lane`")
        adapter.setItems(data.items)
    }
}