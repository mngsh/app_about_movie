package ru.androidschool.intensiv.domain.repository

import io.reactivex.Single
import ru.androidschool.intensiv.data.vo.MovieDetail

interface MovieDetailRepository {
    fun getMovieDetail(): Single<MovieDetail>
}