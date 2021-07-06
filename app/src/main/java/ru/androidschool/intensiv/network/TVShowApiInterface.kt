package ru.androidschool.intensiv.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import ru.androidschool.intensiv.data.tvshow.TVShowResponse

interface TVShowApiInterface {
    @GET("/3/tv/popular")
    fun getTVShow(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Observable<TVShowResponse>
}