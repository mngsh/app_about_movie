package ru.androidschool.intensiv.data

import com.google.gson.annotations.SerializedName

data class Movie(@SerializedName("id")
                 val movieId: Int?,
                 @SerializedName("title")
                 var title: String?
) {
    @SerializedName("poster_path")
    var posterPath: String? = null
        get() = "https://image.tmdb.org/t/p/w500$field"
}
