package ru.androidschool.intensiv.data.vo

data class TVShow(
    val title: String,
    val image: String?,
    val voteAverage: Double
) {
    val rating: Double
        get() = voteAverage / 2
}
