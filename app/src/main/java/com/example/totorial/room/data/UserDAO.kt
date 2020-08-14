package com.example.totorial.room.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDAO {
    @Insert
    suspend fun insertUser(user: User): Long

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM ${User.TABLE_NAME}")
    suspend fun deleteAll()

    //Live data (auto refresh after delete or update)
    @Query("SELECT * FROM ${User.TABLE_NAME}")
    fun getAllUsers(): LiveData<List<User>>
}