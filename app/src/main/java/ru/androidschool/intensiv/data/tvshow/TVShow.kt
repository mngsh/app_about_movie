package ru.androidschool.intensiv.data.tvshow

import com.google.gson.annotations.SerializedName
import ru.androidschool.intensiv.BuildConfig

data class TVShow(
    @SerializedName("name")
    val title: String
) {
    @SerializedName("poster_path")
    var image: String? = null
        get() = "${BuildConfig.URL_IMAGE}$field"
}
