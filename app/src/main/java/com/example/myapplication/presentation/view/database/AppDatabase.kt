package com.example.myapplication.presentation.view.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.presentation.view.database.dao.UserDAO
import com.example.myapplication.presentation.view.database.model.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDAO
}