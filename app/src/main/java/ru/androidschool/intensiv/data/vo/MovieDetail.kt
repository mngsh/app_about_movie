package ru.androidschool.intensiv.data.vo

data class MovieDetail(
    val backdropPath: String,
    val budget: Int,
    val id: Int,
    val title: String,
    val description: String,
    val yearCreate: String,
    var image: String?
)
