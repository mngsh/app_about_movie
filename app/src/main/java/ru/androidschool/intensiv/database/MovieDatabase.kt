package ru.androidschool.intensiv.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.androidschool.intensiv.data.Movie


@Database(entities = [Movie::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
}