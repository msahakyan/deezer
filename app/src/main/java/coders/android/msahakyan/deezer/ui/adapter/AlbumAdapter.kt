package coders.android.msahakyan.deezer.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coders.android.msahakyan.deezer.R
import coders.android.msahakyan.deezer.ui.inflate
import coders.android.msahakyan.deezer.ui.loadUrl
import coders.android.msahakyan.deezer_api.model.Album
import coders.android.msahakyan.deezer_api.model.PictureType
import coders.android.msahakyan.deezer_api.model.buildCover
import kotlinx.android.synthetic.main.item_album.view.album_cover
import kotlinx.android.synthetic.main.item_album.view.album_title
import kotlinx.android.synthetic.main.item_album.view.album_tracks_number

/**
 * @author msahakyan.
 */
class AlbumAdapter(
    private val onItemClicked: (Album, Int) -> Unit
) : RecyclerView.Adapter<AlbumItemViewHolder>() {

    private val list: MutableList<Album> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AlbumItemViewHolder(
            containerView = parent.inflate(R.layout.item_album),
            onItemClicked = onItemClicked
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AlbumItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setItems(items: List<Album>?) = items?.let {
        list.apply {
            clear()
            addAll(it)
            notifyDataSetChanged()
        }
    }
}

class AlbumItemViewHolder(
    private val containerView: View,
    private val onItemClicked: (Album, Int) -> Unit
) : RecyclerView.ViewHolder(containerView) {

    fun bind(album: Album) = with(containerView) {
        album_cover.loadUrl(album.cover?.buildCover(PictureType.BIG), R.drawable.fallback_album)
        album_title.text = album.title
        album_tracks_number.text = album.nb_tracks.toString()
        setOnClickListener {
            onItemClicked.invoke(
                album, adapterPosition
            )
        }
    }
}