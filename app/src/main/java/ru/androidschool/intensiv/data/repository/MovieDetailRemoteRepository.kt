package ru.androidschool.intensiv.data.repository

import io.reactivex.Single
import ru.androidschool.intensiv.data.mappers.MovieDetailsMapper
import ru.androidschool.intensiv.data.network.MovieApiClient
import ru.androidschool.intensiv.data.vo.MovieDetail
import ru.androidschool.intensiv.domain.repository.MovieDetailRepository

class MovieDetailRemoteRepository : MovieDetailRepository {
    override fun getMovieDetail(): Single<MovieDetail> {
        return MovieApiClient.apiClient.getMovieDetail().map { MovieDetailsMapper.toValueObject(it) }
    }
}