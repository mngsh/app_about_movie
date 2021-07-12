package ru.androidschool.intensiv.data.vo

data class Movie(
    val id: Int?,
    var title: String?,
    val image: String?,
    val voteAverage: Double
) {
    val rating: Double
        get() = voteAverage / 2
}
