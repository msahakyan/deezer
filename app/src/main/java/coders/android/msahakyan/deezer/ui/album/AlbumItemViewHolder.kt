package coders.android.msahakyan.deezer.ui.album

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coders.android.msahakyan.deezer.R
import coders.android.msahakyan.deezer.ui.loadUrl
import coders.android.msahakyan.deezer_api.model.Album
import kotlinx.android.synthetic.main.item_album.view.album_cover
import kotlinx.android.synthetic.main.item_album.view.album_title
import kotlinx.android.synthetic.main.item_album.view.album_tracks_number

/**
 * @author msahakyan.
 */
class AlbumItemViewHolder(
    private val containerView: View,
    private val onItemClicked: (Album, Int) -> Unit
) : RecyclerView.ViewHolder(containerView) {

    fun bind(album: Album) = with(containerView) {
        album_cover.loadUrl(album.cover, R.drawable.fallback_album)
        album_title.text = album.title
        album_tracks_number.text = album.nb_tracks.toString()
        setOnClickListener {
            onItemClicked.invoke(
                album, adapterPosition
            )
        }
    }
}