package ru.androidschool.intensiv.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Observable


@Dao
interface MovieDAO {
    @Insert
    fun save(movieEntity: MovieEntity):Completable

    @Delete
    fun delete(movieEntity: MovieEntity):Completable

    @Query("SELECT * FROM likedMovie")
    fun getAllMovie(): Observable<List<MovieEntity>>
}