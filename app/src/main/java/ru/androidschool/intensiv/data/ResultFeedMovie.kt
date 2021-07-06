package ru.androidschool.intensiv.data

import com.google.gson.annotations.SerializedName

data class ResultFeedMovie(
    @SerializedName("getNowPlayingMovie")
    val playingMovie: List<Movie>,
    @SerializedName("getRecommendedMovie")
    val recommendedMovie: List<Movie>,
    @SerializedName("getPopularMovie")
    val popularMovie: List<Movie>
)
