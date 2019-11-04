package coders.android.msahakyan.deezer.ui.common

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coders.android.msahakyan.deezer.R
import coders.android.msahakyan.deezer.ui.common.LaneFactoryRegistry.factories
import coders.android.msahakyan.deezer.ui.common.LaneFactoryRegistry.register
import coders.android.msahakyan.deezer.ui.common.lanes.ArtistsLane
import coders.android.msahakyan.deezer.ui.common.lanes.GenresLane
import coders.android.msahakyan.deezer.ui.common.lanes.HeaderLane
import coders.android.msahakyan.deezer.ui.common.lanes.RadiosLane
import coders.android.msahakyan.deezer.ui.common.lanes.TracksLane
import coders.android.msahakyan.deezer.ui.common.lanes.view.ArtistsLaneView
import coders.android.msahakyan.deezer.ui.common.lanes.view.GenresLaneView
import coders.android.msahakyan.deezer.ui.common.lanes.view.HeaderLaneView
import coders.android.msahakyan.deezer.ui.common.lanes.view.RadiosLaneView
import coders.android.msahakyan.deezer.ui.common.lanes.view.TracksLaneView

/**
 * @author msahakyan.
 */

class LanesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list = mutableListOf<Any>()

    companion object {

        init {
            register<HeaderLane, HeaderLaneView>(
                layoutId = R.layout.layout_header_lane,
                type = LaneType.HEADER_LANE
            )
            register<GenresLane, GenresLaneView>(
                layoutId = R.layout.layout_genres_lane,
                type = LaneType.GENRES_LANE
            )
            register<TracksLane, TracksLaneView>(
                layoutId = R.layout.layout_tracks_lane,
                type = LaneType.TRACKS_LANE
            )
            register<ArtistsLane, ArtistsLaneView>(
                layoutId = R.layout.layout_artists_lane,
                type = LaneType.ARTISTS_LANE
            )
            register<RadiosLane, RadiosLaneView>(
                layoutId = R.layout.layout_radios_lane,
                type = LaneType.RADIOS_LANE
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = factories[viewType].create(parent)
        return object : RecyclerView.ViewHolder(view) {}
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = list[position]
        factories.find { it.isResponsible(data) }?.render(holder.itemView, data, position)
    }

    /**
     * Registers a [LaneFactory] for given [layoutId] and [type].
     */
    inline fun <reified S : Lane, reified V : Renderable<S>> register(
        layoutId: Int, type: LaneType
    ) =
        register(
            layoutId,
            { it is S && type.name == it.type.name },
            { view, state, position -> (view as V).render(state as S, position) }
        )
}

interface Lane {
    val type: LaneType
}

enum class LaneType(val value: String?) {
    HEADER_LANE("HeaderLane"),
    GENRES_LANE("GenresLane"),
    TRACKS_LANE("TracksLane"),
    RADIOS_LANE("RadiosLane"),
    ARTISTS_LANE("ArtistsLane"),
    UNKNOWN("Unknown");

    companion object {
        fun fromString(type: String?) =
            values().find { it.value == type } ?: UNKNOWN
    }
}