package coders.android.msahakyan.deezer.di

import com.bumptech.glide.Glide
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * @author msahakyan.
 */

val appModule = module {

    single {
        Glide.with(androidContext())
    }

}