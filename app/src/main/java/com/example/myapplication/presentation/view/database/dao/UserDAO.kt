package com.example.myapplication.presentation.view.database.dao

import androidx.room.*
import com.example.myapplication.presentation.view.database.model.User

@Dao
interface UserDAO {

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Query("DELETE FROM users WHERE id = :userId")
    fun deleteUser(userId: Int)

    @Update
    fun updateUser(user: User)
}