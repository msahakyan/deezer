package coders.android.msahakyan.deezer_api.model

/**
 * @author msahakyan.
 */

data class Album(
    val id: Int,
    val title: String,
    val cover: String?,
    val genre_id: Int?,
    val genres: List<Genre>,
    val label: String?,
    val nb_tracks: Int?,
    val duration: Int?,
    val fans: Int?,
    val rating: Int?,
    val tracklist: String,
    val artist: Artist,
    val tracks: List<Track>
)