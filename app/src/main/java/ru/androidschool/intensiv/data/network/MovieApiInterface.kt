package ru.androidschool.intensiv.data.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.androidschool.intensiv.data.dto.MoviesDTO
import ru.androidschool.intensiv.data.dto.MovieDetailsDTO

interface MovieApiInterface {

    @GET("3/movie/upcoming")
    fun getUpcomingMovie(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Observable<MoviesDTO>

    @GET("/3/movie/top_rated")
    fun getTopRatedMovie(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Observable<MoviesDTO>

    @GET("/3/movie/popular")
    fun getPopularMovie(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Observable<MoviesDTO>

    @GET("/3/movie/{movie_id}")
    fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Observable<MovieDetailsDTO>
}
