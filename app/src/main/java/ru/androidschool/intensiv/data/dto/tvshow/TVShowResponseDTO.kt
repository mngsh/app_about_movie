package ru.androidschool.intensiv.data.dto.tvshow

import com.google.gson.annotations.SerializedName

data class TVShowResponseDTO(@SerializedName("page")
                          val page: Int,
                             @SerializedName("results")
                          val tvShowDTO: List<TVShowDTO>
)
