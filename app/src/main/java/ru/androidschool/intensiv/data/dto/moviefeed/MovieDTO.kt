package ru.androidschool.intensiv.data.dto.moviefeed

import com.google.gson.annotations.SerializedName
import ru.androidschool.intensiv.BuildConfig.URL_IMAGE

data class MovieDTO(
    @SerializedName("id")
    val movieId: Int?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("vote_average")
    val voteAverage: Double
) {
    @SerializedName("poster_path")
    var image: String? = null
        get() = "${URL_IMAGE}$field"
}
