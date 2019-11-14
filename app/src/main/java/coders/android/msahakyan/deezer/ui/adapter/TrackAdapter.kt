package coders.android.msahakyan.deezer.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coders.android.msahakyan.deezer.R
import coders.android.msahakyan.deezer.ui.inflate
import coders.android.msahakyan.deezer.ui.loadUrl
import coders.android.msahakyan.deezer_api.model.PictureType
import coders.android.msahakyan.deezer_api.model.Track
import coders.android.msahakyan.deezer_api.model.buildCover
import kotlinx.android.synthetic.main.item_track.view.track_cover
import kotlinx.android.synthetic.main.item_track.view.track_title

/**
 * @author msahakyan.
 */
class TrackAdapter(
    private val onItemClicked: (Track, Int) -> Unit
) : RecyclerView.Adapter<TrackItemViewHolder>() {

    private val list: MutableList<Track> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TrackItemViewHolder(
            containerView = parent.inflate(R.layout.item_track),
            onItemClicked = onItemClicked
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: TrackItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setItems(items: List<Track>?) = items?.let {
        list.apply {
            clear()
            addAll(it)
            notifyDataSetChanged()
        }
    }
}

class TrackItemViewHolder(
    private val containerView: View,
    private val onItemClicked: (Track, Int) -> Unit
) : RecyclerView.ViewHolder(containerView) {

    fun bind(track: Track) = with(containerView) {
        track_cover.loadUrl(track.album?.cover?.buildCover(PictureType.BIG), -1)
        track_title.text = track.title
        setOnClickListener {
            onItemClicked.invoke(
                track, adapterPosition
            )
        }
    }
}