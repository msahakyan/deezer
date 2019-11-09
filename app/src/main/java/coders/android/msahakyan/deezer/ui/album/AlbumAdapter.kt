package coders.android.msahakyan.deezer.ui.album

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coders.android.msahakyan.deezer.R
import coders.android.msahakyan.deezer.ui.inflate
import coders.android.msahakyan.deezer_api.model.Album

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