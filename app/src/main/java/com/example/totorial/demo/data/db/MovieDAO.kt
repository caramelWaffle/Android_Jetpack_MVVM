package com.example.totorial.demo.data.db

import androidx.room.*
import test_code.data.model.Movie

@Dao
interface MovieDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("DELETE FROM ${Movie.TABLE_NAME}")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM ${Movie.TABLE_NAME}")
    suspend fun getMovies(): List<Movie>

}