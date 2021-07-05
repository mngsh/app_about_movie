package ru.androidschool.intensiv.data.moviedetails

import com.google.gson.annotations.SerializedName
import java.util.*

data class MovieDetails(@SerializedName("backdrop_path")
                        val backdropPath: String,
                        @SerializedName("budget")
                        val budget: Int,
                        @SerializedName("genres")
                        val genres: List<Genres>,
                        @SerializedName("id")
                        val id:Int,
                        @SerializedName("original_title")
                        val title: String,
                        @SerializedName("popularity")
                        val rating: Int,
                        @SerializedName("poster_path")
                        val image: String,
                        @SerializedName("production_companies")
                        val companies: List<ProductionCompanies>,
                        @SerializedName("production_countries")
                        val country: List<ProductionCountry>,
                        @SerializedName("overview")
                        val description: String
)
