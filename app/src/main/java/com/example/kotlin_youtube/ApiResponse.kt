package com.example.kotlin_youtube

import com.google.gson.annotations.SerializedName
import org.json.JSONArray
import org.json.JSONObject

class ApiResponse {
    @SerializedName("user")
    lateinit var user: JSONObject

    @SerializedName("videos")
    lateinit var videos : List<VideoObject>
}