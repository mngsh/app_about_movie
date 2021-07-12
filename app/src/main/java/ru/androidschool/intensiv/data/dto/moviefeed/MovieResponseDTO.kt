package ru.androidschool.intensiv.data.dto.moviefeed

import com.google.gson.annotations.SerializedName

data class MovieResponseDTO(@SerializedName("page")
                          val page:Int,
                            @SerializedName("results")
                          val results: List<MovieDTO>,
                            @SerializedName("total_pages")
                          val totalPages: Int,
                            @SerializedName("total_results")
                          val totalResult: Int)
