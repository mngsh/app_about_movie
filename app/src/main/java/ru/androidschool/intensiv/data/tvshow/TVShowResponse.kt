package ru.androidschool.intensiv.data.tvshow

import com.google.gson.annotations.SerializedName
import java.util.*

data class TVShowResponse(@SerializedName("page")
                          val page: Int,
                          @SerializedName("results")
                          val tvShow: List<TVShow>
)
