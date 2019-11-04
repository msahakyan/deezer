package coders.android.msahakyan.deezer_api

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * @author msahakyan.
 */

object Constants {

    const val API_KEY = "YOUR-API-KEY"
    const val BASE_URL = "https://api.deezer.com/"

    private val TIMEOUT_CONNECT = TimeUnit.SECONDS.toMillis(15)
    private val TIMEOUT_READ = TimeUnit.SECONDS.toMillis(30)
    private val TIMEOUT_WRITE = TimeUnit.SECONDS.toMillis(30)

    fun applyTimeouts(builder: OkHttpClient.Builder): Unit = with(builder) {
        connectTimeout(TIMEOUT_CONNECT, TimeUnit.MILLISECONDS)
        readTimeout(TIMEOUT_READ, TimeUnit.MILLISECONDS)
        writeTimeout(TIMEOUT_WRITE, TimeUnit.MILLISECONDS)
    }
}