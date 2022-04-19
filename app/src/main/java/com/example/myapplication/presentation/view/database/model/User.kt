package com.example.myapplication.presentation.view.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") val age: Int
)