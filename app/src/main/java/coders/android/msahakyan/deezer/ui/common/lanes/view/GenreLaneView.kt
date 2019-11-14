package coders.android.msahakyan.deezer.ui.common.lanes.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coders.android.msahakyan.deezer.ui.adapter.GenreAdapter
import coders.android.msahakyan.deezer.ui.common.Renderable
import coders.android.msahakyan.deezer.ui.common.lanes.GenreLane
import kotlinx.android.synthetic.main.layout_genres_lane.view.recycler_view
import timber.log.Timber

/**
 * @author msahakyan.
 */
class GenreLaneView @JvmOverloads constructor(
    context: Context,
    attrSet: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrSet, defStyle), Renderable<GenreLane> {

    private val adapter: GenreAdapter by lazy { createAdapter() }
    private val layoutManager: RecyclerView.LayoutManager by lazy { LinearLayoutManager(context, RecyclerView.HORIZONTAL, false) }

    private fun createAdapter(): GenreAdapter =
        GenreAdapter(onItemClicked = { genre, position ->
            Toast.makeText(
                context, "Genre ${genre.name} on position ${position + 1} was clicked", Toast.LENGTH_SHORT
            ).show()
        })

    override fun onFinishInflate() {
        super.onFinishInflate()
        recycler_view.adapter = adapter
        recycler_view.layoutManager = layoutManager
    }

    override fun render(data: GenreLane, position: Int) {
        Timber.v("|>>>> `Rendering Genre Lane`")
        adapter.setItems(data.items?.filter { it.name != "Alle" })
    }
}