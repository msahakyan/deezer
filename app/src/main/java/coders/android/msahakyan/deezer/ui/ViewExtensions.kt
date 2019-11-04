package coders.android.msahakyan.deezer.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide

/**
 * @author msahakyan.
 */

fun ImageView.loadUrl(
    url: String?,
    @DrawableRes
    fallbackRes: Int?
) = Glide.with(context)
    .load(url ?: fallbackRes)
    .into(this)

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}