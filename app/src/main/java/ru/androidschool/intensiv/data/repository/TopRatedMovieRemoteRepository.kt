package ru.androidschool.intensiv.data.repository

import io.reactivex.Single
import ru.androidschool.intensiv.data.mappers.MovieMapper
import ru.androidschool.intensiv.data.network.MovieApiClient
import ru.androidschool.intensiv.data.vo.Movie
import ru.androidschool.intensiv.domain.repository.MovieRepository

class TopRatedMovieRemoteRepository : MovieRepository {
    override fun getMovie(): Single<List<Movie>> {
        return MovieApiClient.apiClient.getTopRatedMovie().map { MovieMapper.toValueObject(it) }
    }
}