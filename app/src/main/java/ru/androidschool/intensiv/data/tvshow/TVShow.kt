package ru.androidschool.intensiv.data.tvshow

import com.google.gson.annotations.SerializedName

data class TVShow(@SerializedName("poster_path")
                  val image: String,
                  @SerializedName("popularity")
                  val rating: Int,
                  @SerializedName("name")
                  val title: String)
