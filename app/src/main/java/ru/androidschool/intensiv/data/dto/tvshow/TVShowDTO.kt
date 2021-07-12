package ru.androidschool.intensiv.data.dto.tvshow

import com.google.gson.annotations.SerializedName
import ru.androidschool.intensiv.BuildConfig.URL_IMAGE

data class TVShowDTO(
    @SerializedName("name")
    val title: String,
    @SerializedName("vote_average")
    val voteAverage: Double
) {
    @SerializedName("poster_path")
    var image: String? = null
        get() = "${URL_IMAGE}$field"
}
