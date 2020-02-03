package com.example.kotlin_youtube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_youtube.Networking.NetworkService
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var networkService: NetworkService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.letsbuildthatapp.com/youtube/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        networkService = retrofit.create(NetworkService::class.java)


        recyclerview_main.layoutManager = LinearLayoutManager(this)
        //recyclerview_main.adapter = MainAdapter()

        val videos = fetchJson()

    }

    fun fetchJson(){
        val call = networkService.fetchYoutubeJson()
        lateinit var apiResponse: ApiResponse
        call.enqueue(object: Callback<ApiResponse>{
            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.toString()
                val gson = GsonBuilder().create()

              val homeFeed = gson.fromJson(response, HomeFeed::class.java)
                runOnUiThread {
                    recyclerview_main.adapter = MainAdapter(homeFeed)
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.d("Response", t.localizedMessage)
            }
        })

    }
}
