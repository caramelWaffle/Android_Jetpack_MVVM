package com.example.totorial.room.viewmodel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.totorial.R
import com.example.totorial.room.data.User
import com.example.totorial.room.data.source.UserRepository
import com.example.totorial.template.Event
import com.example.totorial.template.ResourceProvider
import kotlinx.coroutines.*

class RoomViewModel(private val userRepository: UserRepository) : ViewModel(), Observable {

    var users = userRepository.users

    private val statusMessage = MutableLiveData<Event<String>>()
    val message: LiveData<Event<String>>
        get() = statusMessage

    private var isUpdateAndDelete = false
    private lateinit var userToUpdateAndDelete: User

    @Bindable
    val username = MutableLiveData<String>()

    @Bindable
    val email = MutableLiveData<String>()

    @Bindable
    val btnSaveOrUpdateText = MutableLiveData<String>()

    @Bindable
    val btnClearOrDeleteText = MutableLiveData<String>()

    init {
        clearValue()
    }

    fun saveOrUpdateAction() {
        if (!isUpdateAndDelete) {
            val name = username.value!!
            val email = email.value!!
            insertUser(User(0, name, email))
        } else {
            userToUpdateAndDelete.name = username.value.toString()
            userToUpdateAndDelete.email = email.value.toString()
            updateUser(userToUpdateAndDelete)
        }
        clearValue()
    }

    fun clearOrDeleteAction() {
        if (!isUpdateAndDelete) {
            deleteAll()
        } else {
            deleteUser(userToUpdateAndDelete)
        }
        clearValue()
    }

    private fun clearValue() {
        this.username.value = null
        this.email.value = null
        initSaveOrClear()
    }

    fun initSaveOrClear() {
        isUpdateAndDelete = false
        btnSaveOrUpdateText.value = ResourceProvider.resource.getString(R.string.save)
        btnClearOrDeleteText.value = ResourceProvider.resource.getString(R.string.clear_all)
    }

    fun initUpdateAndDelete(user: User) {
        isUpdateAndDelete = true
        username.value = user.name
        email.value = user.email
        userToUpdateAndDelete = user
        btnSaveOrUpdateText.value = ResourceProvider.resource.getString(R.string.update)
        btnClearOrDeleteText.value = ResourceProvider.resource.getString(R.string.delete)
    }

    private fun insertUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        val userId = userRepository.insertUser(user)
        viewModelScope.launch(Dispatchers.Main) {
            if (userId > -1){
                statusMessage.value = Event("User inserted")
            }else{
                statusMessage.value = Event("Error occurred")
            }
        }
    }

    private fun updateUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        val numberOfRow = userRepository.updateUser(user)
        withContext(Dispatchers.Main) {
            if (numberOfRow > 0){
                statusMessage.value = Event("User updated")
            }else{
                statusMessage.value = Event("Error occurred")
            }
        }
    }

    private fun deleteUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        userRepository.deleteUser(user)
        withContext(Dispatchers.Main) {
            statusMessage.value = Event("User deleted")
        }
    }

    private fun deleteAll() = viewModelScope.launch(Dispatchers.IO) {
        userRepository.deleteAll()
        withContext(Dispatchers.Main) {
            statusMessage.value = Event("All users deleted")
        }
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}