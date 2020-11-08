package com.example.myapplication.net

import com.example.myapplication.model.Photo
import retrofit2.Call
import retrofit2.http.*


interface APIService {
    @GET("photos")
    fun getPhotos(): Call<List<Photo>>
}