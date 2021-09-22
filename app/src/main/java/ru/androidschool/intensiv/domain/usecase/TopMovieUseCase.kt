package ru.androidschool.intensiv.domain.usecase

import io.reactivex.Single
import ru.androidschool.intensiv.data.vo.Movie
import ru.androidschool.intensiv.domain.repository.MovieRepository
import ru.androidschool.intensiv.domain.usecase.extensions.addSchedulers

class TopMovieUseCase(private val repository: MovieRepository) {
    fun topMovie(): Single<List<Movie>> {
        return repository.getMovie().addSchedulers()
    }

}