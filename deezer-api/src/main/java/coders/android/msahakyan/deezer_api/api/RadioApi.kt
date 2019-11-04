package coders.android.msahakyan.deezer_api.api

import coders.android.msahakyan.deezer_api.model.PageData
import coders.android.msahakyan.deezer_api.model.Radio
import coders.android.msahakyan.deezer_api.model.RadioGenre
import retrofit2.http.GET

/**
 * @author msahakyan.
 */

interface RadioApi {

    @GET("radio")
    suspend fun fetchRadios(): PageData<Radio>

    @GET("radio/genres")
    suspend fun fetchRadioGenres(): PageData<RadioGenre>

    @GET("radio/top")
    suspend fun fetchTopRadios(): PageData<Radio>
}