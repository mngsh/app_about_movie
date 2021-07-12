package ru.androidschool.intensiv.data.dto

import com.google.gson.annotations.SerializedName
import ru.androidschool.intensiv.data.vo.Movie

data class FeedMovieDTO(
    @SerializedName("getNowPlayingMovie")
    val playingMovie: List<Movie>,
    @SerializedName("getRecommendedMovie")
    val recommendedMovie: List<Movie>,
    @SerializedName("getPopularMovie")
    val popularMovie: List<Movie>
)
