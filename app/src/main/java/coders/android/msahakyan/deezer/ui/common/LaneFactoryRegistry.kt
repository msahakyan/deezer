package coders.android.msahakyan.deezer.ui.common

import android.view.LayoutInflater.from
import android.view.View
import android.view.ViewGroup

/**
 * @author msahakyan.
 */

object LaneFactoryRegistry {

    val factories = mutableListOf<LaneFactory>()

    fun register(
        layoutId: Int,
        isResponsible: (Any) -> Boolean,
        render: (View, Any, Int) -> Unit
    ) {
        factories += object : LaneFactory {
            override val layoutId: Int = layoutId
            override fun isResponsible(state: Any) = isResponsible(state)
            override fun render(view: View, data: Any, position: Int) = render(view, data, position)
        }
    }

    /**
     * Registers a [LaneFactory] for given [layoutId] and [type].
     */
    inline fun <reified S : Lane, reified V : Renderable<S>> register(
        layoutId: Int,
        type: LaneType
    ) = register(
        layoutId,
        { it is S && type.name == it.type.name },
        { view, data, position -> (view as V).render(data as S, position) }
    )
}

interface LaneFactory {

    val layoutId: Int

    fun render(view: View, data: Any, position: Int)

    fun isResponsible(state: Any): Boolean

    fun create(parent: ViewGroup): View =
        from(parent.context).inflate(layoutId, parent, false)
}