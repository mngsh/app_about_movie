package ru.androidschool.intensiv.data.dto.moviefeed

import com.google.gson.annotations.SerializedName

data class FeedMovieDTO(
    @SerializedName("getNowPlayingMovie")
    val playingMovieDTO: List<MovieDTO>,
    @SerializedName("getRecommendedMovie")
    val recommendedMovieDTO: List<MovieDTO>,
    @SerializedName("getPopularMovie")
    val popularMovieDTO: List<MovieDTO>
)
