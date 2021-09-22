package ru.androidschool.intensiv.domain.repository

import io.reactivex.Single
import ru.androidschool.intensiv.data.vo.TVShow

interface TVShowRepository {
    fun popularTVShow(): Single<List<TVShow>>
}