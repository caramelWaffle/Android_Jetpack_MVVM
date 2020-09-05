package com.example.totorial.retrofit.manager

import com.example.totorial.retrofit.data.Album
import com.example.totorial.retrofit.data.AlbumItem
import retrofit2.Response
import retrofit2.http.*

interface AlbumService {

    @GET("/albums")
    suspend fun getAlbums(): Response<Album>

    @GET("/albums")
    suspend fun getAlbumsByUserId(
        @Query("userId")
        userId: Int): Response<Album>  //albums?userId=1   ?key=value

    @GET("/albums/{id}")
    suspend fun getAlbumsById(
        @Path("id")
        albumId: Int): Response<AlbumItem> // albums/1   /value

    @POST("/albums")
    suspend fun uploadAlbum(
        @Body
        albumItem: AlbumItem
    ): Response<AlbumItem>
}