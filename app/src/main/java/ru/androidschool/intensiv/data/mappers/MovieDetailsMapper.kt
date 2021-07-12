package ru.androidschool.intensiv.data.mappers

import ru.androidschool.intensiv.data.dto.moviedetail.MovieDetailsDTO
import ru.androidschool.intensiv.data.vo.MovieDetail

object MovieDetailsMapper {

    fun toValueObject(dto: MovieDetailsDTO): MovieDetail {
        return MovieDetail(
            backdropPath = dto.backdropPath,
            budget = dto.budget,
            id = dto.id,
            title = dto.title,
            description = dto.description,
            yearCreate = dto.yearCreate,
            image = dto.image
        )
    }
}