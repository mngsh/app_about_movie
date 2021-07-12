package ru.androidschool.intensiv.data.dto

import com.google.gson.annotations.SerializedName
import ru.androidschool.intensiv.data.vo.TVShow

data class TVShowDTO(@SerializedName("page")
                          val page: Int,
                     @SerializedName("results")
                          val tvShow: List<TVShow>
)
