package coders.android.msahakyan.deezer.ui.common

/**
 * @author msahakyan.
 */

interface Renderable<T> {
    fun render(data: T, position: Int)
}