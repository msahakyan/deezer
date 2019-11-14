package coders.android.msahakyan.deezer.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coders.android.msahakyan.deezer.R
import coders.android.msahakyan.deezer.ui.inflate
import coders.android.msahakyan.deezer.ui.loadUrl
import coders.android.msahakyan.deezer_api.model.Genre
import coders.android.msahakyan.deezer_api.model.PictureType
import coders.android.msahakyan.deezer_api.model.buildCover
import kotlinx.android.synthetic.main.item_genre.view.genre_cover
import kotlinx.android.synthetic.main.item_genre.view.genre_title

/**
 * @author msahakyan.
 */

class GenreAdapter(
    private val onItemClicked: (Genre, Int) -> Unit
) : RecyclerView.Adapter<GenreItemViewHolder>() {

    private val list: MutableList<Genre> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        GenreItemViewHolder(
            containerView = parent.inflate(R.layout.item_genre),
            onItemClicked = onItemClicked
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: GenreItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setItems(items: List<Genre>?) = items?.let {
        list.apply {
            clear()
            addAll(it)
            notifyDataSetChanged()
        }
    }
}

class GenreItemViewHolder(
    private val containerView: View,
    private val onItemClicked: (Genre, Int) -> Unit
) : RecyclerView.ViewHolder(containerView) {

    fun bind(genre: Genre) = with(containerView) {
        genre_cover.loadUrl(genre.picture?.buildCover(PictureType.BIG), -1)
        genre_title.text = genre.name
        setOnClickListener {
            onItemClicked.invoke(
                genre, adapterPosition
            )
        }
    }
}