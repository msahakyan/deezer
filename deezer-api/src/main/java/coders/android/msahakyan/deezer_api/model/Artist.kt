package coders.android.msahakyan.deezer_api.model

import com.google.gson.annotations.SerializedName

/**
 * @author msahakyan.
 */

data class Artist(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("picture")
    val picture: String?,
    @SerializedName("link")
    val link: String?,
    @SerializedName("nb_album")
    val nb_album: Int?,
    @SerializedName("nb_fan")
    val nb_fan: Int?,
    @SerializedName("tracklist")
    val tracklist: String?,
    @SerializedName("radio")
    val radio: Boolean
)