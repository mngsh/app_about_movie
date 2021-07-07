package ru.androidschool.intensiv.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Liked movie")
data class Movie(
    @PrimaryKey
    @ColumnInfo(name = "movieID")
    val id: Long,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "image")
    val image: String?
)
