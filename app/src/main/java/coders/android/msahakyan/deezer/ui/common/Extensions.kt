package coders.android.msahakyan.deezer.ui.common

import timber.log.Timber

/**
 * @author msahakyan.
 */

fun log(msg: String) =
    Timber.d("[${Thread.currentThread().name}] -- $msg")