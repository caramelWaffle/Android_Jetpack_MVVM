package com.example.totorial.room.data.source

import com.example.totorial.room.data.User
import com.example.totorial.room.data.UserDAO

class UserRepository(private val userDAO: UserDAO) {

    val users = userDAO.getAllUsers()

    suspend fun insertUser(user: User): Long{
       return userDAO.insertUser(user) // Return newly added ID
    }

    suspend fun updateUser(user: User): Int{
        return userDAO.updateUser(user) // Return affected number of rows
    }

    suspend fun deleteUser(user: User){
        userDAO.deleteUser(user)
    }

    suspend fun deleteAll(){
        userDAO.deleteAll()
    }
}