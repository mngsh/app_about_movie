package ru.androidschool.intensiv.data.moviedetails

import com.google.gson.annotations.SerializedName

data class Genres(@SerializedName("id")
                  val id: Int,
                  @SerializedName("name")
                  val nameId:String)