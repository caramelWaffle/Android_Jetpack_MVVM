package com.example.totorial.coroutine.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.totorial.coroutine.manager.DataManager
import kotlinx.coroutines.*

class CoroutineViewModel() : ViewModel(), Observable {

    @Bindable
    val count = MutableLiveData<Int>()
    var userText = MutableLiveData<String>()

    init {
        count.value = 0
    }

    fun increaseCount() {
        this.count.value = this.count.value?.plus(1)
    }

    fun download() {
//        Dispatchers.Main == UI Thread
//        Dispatchers.IO == Background Thread (Shared pool)
//        Dispatchers.Default == CPU intensive task (High computational)

//        launch == launch without blocking current thread and it can return value after finish
        CoroutineScope(Dispatchers.IO).launch {
            downloadUserData()
        }

//        Run in Background
//        CoroutineScope(Dispatchers.IO).launch {
//            Log.i("myTag", "Start")
//            val stock1 = async { getStock1() }
//            val stock2 = async { getStock2() }
//            val total = stock1.await() + stock2.await()
//            Log.i("myTag", "Total is $total")
//        }

//        Run in Main
        viewModelScope.launch(Dispatchers.Main) {
            Log.i("myTag", "Start")
            // Change to Background
            val stock1 = async(Dispatchers.IO) { getStock1() }
            val stock2 = async(Dispatchers.IO) { getStock2() }
            val total = stock1.await() + stock2.await()
            Toast.makeText(Contextor.getContext(), "Total is $total", Toast.LENGTH_SHORT).show()
        }

//        Running and receiving data from function
//        if have multi coroutine start calling it with main and io in sub coroutine
        val dataManager = DataManager()
        viewModelScope.launch(Dispatchers.Main) {
            Toast.makeText(Contextor.getContext(), dataManager.getTotalUserCount().toString(), Toast.LENGTH_LONG).show()
            Toast.makeText(Contextor.getContext(), dataManager.getTotalUserCount2().toString(), Toast.LENGTH_LONG).show()
        }

    }

    private suspend fun getStock1():Int{
        delay(10000)
        Log.i("myTag", "Stock 1 returned")
        return 55000
    }

    private suspend fun getStock2():Int{
        delay(8000)
        Log.i("myTag", "Stock 2 returned")
        return 35000
    }


    private suspend fun downloadUserData() {
        var userId = 0
        for (i in 1..200000) {
            userId = i
            withContext(Dispatchers.Main) {
                userText.value = "Downloading user ${userId} in ${Thread.currentThread().name}"
            }
        }
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }


}