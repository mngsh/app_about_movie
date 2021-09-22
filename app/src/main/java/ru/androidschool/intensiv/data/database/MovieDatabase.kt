package ru.androidschool.intensiv.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.androidschool.intensiv.data.entity.MovieEntity


@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDAO(): MovieDAO

    companion object {
        private var instance: MovieDatabase? = null

        @Synchronized
        fun getContext(context: Context): MovieDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, MovieDatabase::class.java, "MovieDatabase")
                    .build()
            }
            return instance!!
        }
    }
}