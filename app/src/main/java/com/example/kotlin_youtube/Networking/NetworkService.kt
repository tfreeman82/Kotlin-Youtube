package com.example.kotlin_youtube.Networking

import com.example.kotlin_youtube.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface NetworkService {

    @GET("home_feed")
    fun fetchYoutubeJson(): Call<ApiResponse>
}