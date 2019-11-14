package coders.android.msahakyan.deezer.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coders.android.msahakyan.deezer.R
import coders.android.msahakyan.deezer.ui.inflate
import coders.android.msahakyan.deezer.ui.loadUrl
import coders.android.msahakyan.deezer_api.model.Artist
import kotlinx.android.synthetic.main.item_artist.view.artist_cover
import kotlinx.android.synthetic.main.item_artist.view.artist_name

/**
 * @author msahakyan.
 */
class ArtistAdapter(
    private val onItemClicked: (Artist, Int) -> Unit
) : RecyclerView.Adapter<ArtistItemViewHolder>() {

    private val list: MutableList<Artist> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ArtistItemViewHolder(
            containerView = parent.inflate(R.layout.item_artist),
            onItemClicked = onItemClicked
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ArtistItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setItems(items: List<Artist>?) = items?.let {
        list.apply {
            clear()
            addAll(it)
            notifyDataSetChanged()
        }
    }
}

class ArtistItemViewHolder(
    private val containerView: View,
    private val onItemClicked: (Artist, Int) -> Unit
) : RecyclerView.ViewHolder(containerView) {

    fun bind(artist: Artist) = with(containerView) {
        artist_cover.loadUrl(artist.picture_big, -1)
        artist_name.text = artist.name
        setOnClickListener {
            onItemClicked.invoke(
                artist, adapterPosition
            )
        }
    }
}