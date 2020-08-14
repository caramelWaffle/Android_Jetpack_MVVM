package com.example.totorial.room.data.source

import com.example.totorial.room.data.User
import com.example.totorial.room.data.UserDAO

class UserRepository(private val userDAO: UserDAO) {

    val users = userDAO.getAllUsers()

    suspend fun insertUser(user: User){
        userDAO.insertUser(user)
    }

    suspend fun updateUser(user: User){
        userDAO.updateUser(user)
    }

    suspend fun deleteUser(user: User){
        userDAO.deleteUser(user)
    }

    suspend fun deleteAll(){
        userDAO.deleteAll()
    }
}