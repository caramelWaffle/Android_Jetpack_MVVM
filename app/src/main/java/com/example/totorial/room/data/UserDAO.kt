package com.example.totorial.room.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDAO {
    @Insert
    suspend fun insertUser(user: User): Long // Return newly added ID

    @Update
    suspend fun updateUser(user: User): Int // Return affected number of rows

    @Delete
    suspend fun deleteUser(user: User) // Return deleted number of rows

    @Query("DELETE FROM ${User.TABLE_NAME}") // Return deleted number of rows
    suspend fun deleteAll()

    //Live data (auto refresh after delete or update)
    @Query("SELECT * FROM ${User.TABLE_NAME}")
    fun getAllUsers(): LiveData<List<User>>
}