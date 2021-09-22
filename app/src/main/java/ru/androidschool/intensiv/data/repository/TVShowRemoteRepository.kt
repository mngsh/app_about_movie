package ru.androidschool.intensiv.data.repository

import io.reactivex.Single
import ru.androidschool.intensiv.data.mappers.TVShowMapper
import ru.androidschool.intensiv.data.network.TVShowApiClient
import ru.androidschool.intensiv.data.vo.TVShow
import ru.androidschool.intensiv.domain.repository.TVShowRepository

class TVShowRemoteRepository : TVShowRepository {
    override fun popularTVShow(): Single<List<TVShow>> {
        return TVShowApiClient.apiClient.getTVShow().map { TVShowMapper.toValueObject(it) }
    }
}