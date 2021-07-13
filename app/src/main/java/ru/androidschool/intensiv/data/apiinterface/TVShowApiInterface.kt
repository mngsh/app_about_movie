package ru.androidschool.intensiv.data.apiinterface

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.androidschool.intensiv.BuildConfig.API_KEY
import ru.androidschool.intensiv.BuildConfig.LANGUAGE
import ru.androidschool.intensiv.data.dto.tvshow.TVShowResponseDTO

interface TVShowApiInterface {
    @GET("/3/tv/popular")
    fun getTVShow(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE
    ): Single<TVShowResponseDTO>
}