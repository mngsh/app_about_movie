package ru.androidschool.intensiv.data.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import ru.androidschool.intensiv.data.dto.tvshow.TVShowResponseDTO

interface TVShowApiInterface {
    @GET("/3/tv/popular")
    fun getTVShow(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Observable<TVShowResponseDTO>
}