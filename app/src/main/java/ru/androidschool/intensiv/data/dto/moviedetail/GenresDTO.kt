package ru.androidschool.intensiv.data.dto.moviedetail

import com.google.gson.annotations.SerializedName

data class GenresDTO(@SerializedName("id")
                  val id: Int,
                     @SerializedName("name")
                  val name:String)
