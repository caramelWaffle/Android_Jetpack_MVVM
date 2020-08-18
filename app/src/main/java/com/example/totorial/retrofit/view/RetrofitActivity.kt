package com.example.totorial.retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.totorial.R
import com.example.totorial.retrofit.data.Album
import com.example.totorial.retrofit.data.AlbumItem
import com.example.totorial.retrofit.manager.AlbumService
import com.example.totorial.retrofit.manager.RetrofitInstance
import retrofit2.Response

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        val albumService = RetrofitInstance.getInstances().create(AlbumService::class.java)
        val responseLiveData: LiveData<Response<AlbumItem>> = liveData {
            emit(albumService.uploadAlbum(AlbumItem(1, "test", 2)))
        }

        responseLiveData.observe(this, Observer { response ->
            val albumList = response?.body()
            Log.i("myTag", albumList?.id.toString() + " "+ albumList?.title)

//            albumList?.forEach {
//                Log.i("myTag", it.id.toString() + " "+ it.title)
//            }
        })

    }
}