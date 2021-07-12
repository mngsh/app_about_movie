package ru.androidschool.intensiv.data.mappers

import ru.androidschool.intensiv.data.dto.tvshow.TVShowDTO
import ru.androidschool.intensiv.data.dto.tvshow.TVShowResponseDTO
import ru.androidschool.intensiv.data.vo.TVShow

object TVShowMapper {

    fun toValueObject(dto: TVShowResponseDTO): List<TVShow> {
        return dto.tvShowDTO.map { roValueObject(it) }
    }

    private fun roValueObject(dto: TVShowDTO): TVShow {
        return TVShow(
            title = dto.title,
            image = dto.image,
            voteAverage = dto.voteAverage
        )
    }
}