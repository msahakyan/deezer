package coders.android.msahakyan.deezer

import android.app.Application
import coders.android.msahakyan.deezer.di.appModule
import coders.android.msahakyan.deezer.di.viewModelsModule
import coders.android.msahakyan.deezer_api.di.networkModule
import coders.android.msahakyan.deezer_api.di.repositoriesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

/**
 * @author msahakyan.
 */
class DeezerApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeLibraries()
    }

    private fun initializeLibraries() {
        initializeTimber()
        initializeKoin()
    }

    private fun initializeTimber() {
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }

    private fun initializeKoin() {
        startKoin {
            androidContext(this@DeezerApp)
            androidLogger(level = Level.DEBUG)
            modules(
                listOf(
                    appModule,
                    viewModelsModule,
                    networkModule,
                    repositoriesModule
                )
            )
        }
    }
}