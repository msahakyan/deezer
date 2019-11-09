package coders.android.msahakyan.deezer_api.model

import com.google.gson.annotations.SerializedName

/**
 * @author msahakyan.
 */

data class Radio(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("picture")
    val picture: String?,
    @SerializedName("tracklist")
    val tracklist: String?
)