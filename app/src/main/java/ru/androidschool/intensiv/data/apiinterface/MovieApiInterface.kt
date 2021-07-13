package ru.androidschool.intensiv.data.apiinterface

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.androidschool.intensiv.BuildConfig.API_KEY
import ru.androidschool.intensiv.BuildConfig.LANGUAGE
import ru.androidschool.intensiv.data.dto.moviedetail.MovieDetailsDTO
import ru.androidschool.intensiv.data.dto.moviefeed.MovieResponseDTO

interface MovieApiInterface {

    @GET("3/movie/upcoming")
    fun getUpcomingMovie(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE
    ): Single<MovieResponseDTO>

    @GET("/3/movie/top_rated")
    fun getTopRatedMovie(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE
    ): Single<MovieResponseDTO>

    @GET("/3/movie/popular")
    fun getPopularMovie(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE
    ): Single<MovieResponseDTO>

    @GET("/3/movie/{movie_id}")
    fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE
    ): Single<MovieDetailsDTO>
}
