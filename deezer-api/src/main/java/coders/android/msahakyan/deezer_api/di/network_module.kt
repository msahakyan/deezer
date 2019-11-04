package coders.android.msahakyan.deezer_api.di


import android.content.Context
import coders.android.msahakyan.deezer_api.BuildConfig
import coders.android.msahakyan.deezer_api.Constants
import coders.android.msahakyan.deezer_api.api.AlbumApi
import coders.android.msahakyan.deezer_api.api.ArtistApi
import coders.android.msahakyan.deezer_api.api.GenreApi
import coders.android.msahakyan.deezer_api.api.PlaylistApi
import coders.android.msahakyan.deezer_api.api.SearchApi
import coders.android.msahakyan.deezer_api.api.TrackApi
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

/**
 * @author msahakyan.
 */

val networkModule = module {

    single {
        val httpCacheDirectory = File(get<Context>().cacheDir.absolutePath, "HttpCache")
        Cache(httpCacheDirectory, HTTP_CACHE_SIZE)
    }

    single {
        Interceptor { chain ->
            val newUrl = chain.request().url()
                .newBuilder()
                .addQueryParameter("api_key", Constants.API_KEY)
                .build()

            val newRequest = chain.request()
                .newBuilder()
                .url(newUrl)
                .build()

            chain.proceed(newRequest)
        }
    }

    single {
        val client = OkHttpClient.Builder()
            .also { builder ->
                Constants.applyTimeouts(builder)
                builder.applyLogging()
            }
            .addInterceptor { chain ->
                val newRequest = chain.request()
                    .newBuilder()
                    .addHeader("api_key", Constants.API_KEY)
                    .build()
                chain.proceed(newRequest)
            }
            .build()
        createRetrofit(client = client)
    }

    retrofitApi<SearchApi>()
    retrofitApi<AlbumApi>()
    retrofitApi<ArtistApi>()
    retrofitApi<GenreApi>()
    retrofitApi<PlaylistApi>()
    retrofitApi<TrackApi>()
}

const val HTTP_CACHE_SIZE = 10L * 1024

inline fun <reified T : Any> Module.retrofitApi() {
    single<T> {
        get<Retrofit>().create(T::class.java)
    }
}

private fun createRetrofit(
    baseUrl: String = Constants.BASE_URL,
    client: OkHttpClient
) = Retrofit.Builder()
    .baseUrl(baseUrl)
    .client(client)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .build()

private fun OkHttpClient.Builder.applyLogging(): OkHttpClient.Builder {
    if (BuildConfig.DEBUG) {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        this.addInterceptor(logging)
    }
    return this
}