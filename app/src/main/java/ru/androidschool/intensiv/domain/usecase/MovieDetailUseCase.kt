package ru.androidschool.intensiv.domain.usecase

import io.reactivex.Single
import ru.androidschool.intensiv.data.vo.MovieDetail
import ru.androidschool.intensiv.domain.repository.MovieDetailRepository
import ru.androidschool.intensiv.domain.usecase.extensions.addSchedulers

class MovieDetailUseCase(private val repository: MovieDetailRepository) {
    fun movieDetail() : Single<MovieDetail> {
        return repository.getMovieDetail().addSchedulers()
    }
}