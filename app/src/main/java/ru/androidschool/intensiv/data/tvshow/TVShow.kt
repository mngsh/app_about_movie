package ru.androidschool.intensiv.data.tvshow

import com.google.gson.annotations.SerializedName

data class TVShow(
    @SerializedName("name")
    val title: String
) {
    @SerializedName("poster_path")
    var image: String? = null
        get() = "https://image.tmdb.org/t/p/w500$field"
}
