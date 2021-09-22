package ru.androidschool.intensiv.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "likedMovie")
data class MovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "movieID")
    val id: Long,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "image")
    val image: String?
)
