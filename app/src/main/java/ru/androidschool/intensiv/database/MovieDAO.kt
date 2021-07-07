package ru.androidschool.intensiv.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface MovieDAO {

    @Insert
    fun save(movie: List<Movie>)

    @Delete
    fun delete(movie: Movie)

    @Query("SELECT * FROM `Liked movie`")
    fun getAllMovie(movie: List<Movie>)
}