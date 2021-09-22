package ru.androidschool.intensiv.domain.usecase

import io.reactivex.Single
import ru.androidschool.intensiv.data.vo.TVShow
import ru.androidschool.intensiv.domain.repository.TVShowRepository
import ru.androidschool.intensiv.domain.usecase.extensions.addSchedulers

class TVShowUseCase(private val repository: TVShowRepository) {

    fun popularTVShow(): Single<List<TVShow>> {
        return repository.popularTVShow().addSchedulers()
    }

}