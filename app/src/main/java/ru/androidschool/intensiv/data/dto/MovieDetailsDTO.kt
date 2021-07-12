package ru.androidschool.intensiv.data.dto

import com.google.gson.annotations.SerializedName

data class MovieDetailsDTO(
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("budget")
    val budget: Int,
    @SerializedName("genres")
    val genres: List<GenresDTO>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("production_companies")
    val companies: List<ProductionCompaniesDTO>,
    @SerializedName("production_countries")
    val countryDTO: List<ProductionCountryDTO>,
    @SerializedName("overview")
    val description: String,
    @SerializedName("release_date")
    val yearCreate: String

) {
    @SerializedName("poster_path")
    var image: String? = null
        get() = "https://image.tmdb.org/t/p/w500$field"
}
