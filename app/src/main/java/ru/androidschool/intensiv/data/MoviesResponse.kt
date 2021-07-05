package ru.androidschool.intensiv.data

import com.google.gson.annotations.SerializedName
import java.util.*

data class MoviesResponse(@SerializedName("page")
                          val page:Int,
                          @SerializedName("results")
                          val results: List<Movie>,
                          @SerializedName("total_pages")
                          val totalPages: Int,
                          @SerializedName("total_results")
                          val totalResult: Int)
