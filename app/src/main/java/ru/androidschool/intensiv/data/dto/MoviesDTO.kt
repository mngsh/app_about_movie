package ru.androidschool.intensiv.data.dto

import com.google.gson.annotations.SerializedName
import ru.androidschool.intensiv.data.vo.Movie

data class MoviesDTO(@SerializedName("page")
                          val page:Int,
                     @SerializedName("results")
                          val results: List<Movie>,
                     @SerializedName("total_pages")
                          val totalPages: Int,
                     @SerializedName("total_results")
                          val totalResult: Int)
