package ru.androidschool.intensiv.data.mappers

import ru.androidschool.intensiv.data.dto.moviefeed.MovieDTO
import ru.androidschool.intensiv.data.dto.moviefeed.MovieResponseDTO
import ru.androidschool.intensiv.data.vo.Movie

object MovieMapper {

    fun toValueObject(dto: MovieResponseDTO): List<Movie> {
        return dto.results.map { toValueObject(it) }
    }

    private fun toValueObject(dto: MovieDTO): Movie {
        return Movie(
            id = dto.movieId,
            title = dto.title,
            image = dto.image,
            voteAverage = dto.voteAverage
        )
    }
}