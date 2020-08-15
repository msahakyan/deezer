package coders.android.msahakyan.deezer.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coders.android.msahakyan.deezer.R
import coders.android.msahakyan.deezer.ui.inflate
import coders.android.msahakyan.deezer.ui.loadUrl
import coders.android.msahakyan.deezer_api.model.PictureType
import coders.android.msahakyan.deezer_api.model.Radio
import coders.android.msahakyan.deezer_api.model.buildCover
import kotlinx.android.synthetic.main.item_radio.view.radio_cover
import kotlinx.android.synthetic.main.item_radio.view.radio_title

/**
 * @author msahakyan.
 */

class RadioAdapter(
    private val onItemClicked: (Radio, Int) -> Unit
) : RecyclerView.Adapter<RadioItemViewHolder>() {

    private val list: MutableList<Radio> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RadioItemViewHolder(
            containerView = parent.inflate(R.layout.item_radio),
            onItemClicked = onItemClicked
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RadioItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setItems(items: List<Radio>?) = items?.let {
        list.apply {
            clear()
            addAll(it)
            notifyDataSetChanged()
        }
    }
}

class RadioItemViewHolder(
    private val containerView: View,
    private val onItemClicked: (Radio, Int) -> Unit
) : RecyclerView.ViewHolder(containerView) {

    fun bind(radio: Radio) = with(containerView) {
        radio_cover.loadUrl(radio.picture?.buildCover(PictureType.BIG), -1)
        radio_title.text = radio.title
        setOnClickListener {
            onItemClicked.invoke(
                radio, adapterPosition
            )
        }
    }
}