package coders.android.msahakyan.deezer.ui.common

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coders.android.msahakyan.deezer.R
import coders.android.msahakyan.deezer.ui.common.LaneFactoryRegistry.factories
import coders.android.msahakyan.deezer.ui.common.LaneFactoryRegistry.register
import coders.android.msahakyan.deezer.ui.common.lanes.AlbumLane
import coders.android.msahakyan.deezer.ui.common.lanes.ArtistLane
import coders.android.msahakyan.deezer.ui.common.lanes.GenreLane
import coders.android.msahakyan.deezer.ui.common.lanes.HeaderLane
import coders.android.msahakyan.deezer.ui.common.lanes.RadioLane
import coders.android.msahakyan.deezer.ui.common.lanes.TrackLane
import coders.android.msahakyan.deezer.ui.common.lanes.view.AlbumLaneView
import coders.android.msahakyan.deezer.ui.common.lanes.view.ArtistLaneView
import coders.android.msahakyan.deezer.ui.common.lanes.view.GenreLaneView
import coders.android.msahakyan.deezer.ui.common.lanes.view.HeaderLaneView
import coders.android.msahakyan.deezer.ui.common.lanes.view.RadioLaneView
import coders.android.msahakyan.deezer.ui.common.lanes.view.TrackLaneView

/**
 * @author msahakyan.
 */

class LanesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val lanes = mutableListOf<Any>()

    companion object {
        init {
            register<HeaderLane, HeaderLaneView>(
                layoutId = R.layout.layout_header_lane,
                type = LaneType.HEADER_LANE
            )
            register<GenreLane, GenreLaneView>(
                layoutId = R.layout.layout_genres_lane,
                type = LaneType.GENRE_LANE
            )
            register<TrackLane, TrackLaneView>(
                layoutId = R.layout.layout_tracks_lane,
                type = LaneType.TRACK_LANE
            )
            register<ArtistLane, ArtistLaneView>(
                layoutId = R.layout.layout_artists_lane,
                type = LaneType.ARTIST_LANE
            )
            register<RadioLane, RadioLaneView>(
                layoutId = R.layout.layout_radios_lane,
                type = LaneType.RADIO_LANE
            )
            register<AlbumLane, AlbumLaneView>(
                layoutId = R.layout.layout_albums_lane,
                type = LaneType.ALBUM_LANE
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = factories[viewType].create(parent)
        return object : RecyclerView.ViewHolder(view) {}
    }

    override fun getItemCount() = lanes.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = lanes[position]
        factories.find { it.isResponsible(data) }?.render(holder.itemView, data, position)
    }

    override fun getItemViewType(position: Int): Int {
        val item = lanes[position]
        return factories.indexOfFirst { it.isResponsible(item) }
    }

    fun addLane(lane: Any) =
        lanes.add(lane)
            .also { notifyItemInserted(lanes.size) }

    fun addLaneFirst(lane: Any) =
        lanes.add(0, lane)
            .also { notifyItemInserted(0) }

    /**
     * Clears a list of old items, sets new ones instead
     * and notifies about data set changed in the end.
     */
    fun setContent(items: List<Any>) {
        with(lanes) {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }
}

interface Lane {
    val type: LaneType
}

enum class LaneType(val value: String?) {
    HEADER_LANE("HeaderLane"),
    GENRE_LANE("GenreLane"),
    ALBUM_LANE("AlbumLane"),
    TRACK_LANE("TrackLane"),
    RADIO_LANE("RadioLane"),
    ARTIST_LANE("ArtistLane"),
    UNKNOWN("Unknown");

    companion object {
        fun fromString(type: String?) =
            values().find { it.value == type } ?: UNKNOWN
    }
}