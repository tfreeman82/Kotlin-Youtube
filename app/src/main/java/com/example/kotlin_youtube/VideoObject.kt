package com.example.kotlin_youtube

import com.google.gson.annotations.SerializedName
import org.json.JSONObject

class VideoObject {
    @SerializedName("id")
    lateinit var id: String

    @SerializedName("name")
    lateinit var name: String

    @SerializedName("link")
    lateinit var link: String

    @SerializedName("imageUrl")
    lateinit var imageUrl: String

    @SerializedName("numberOfViews")
    lateinit var numberOfViews: String

    @SerializedName("channel")
    lateinit var channel: Channel


    class Channel {
        @SerializedName("name")
        lateinit var name: String

        @SerializedName("profileImageUrl")
        lateinit var profileImageUrl: String

        @SerializedName("numberOfSubscribers")
        lateinit var numberOfSubscribers: String
    }
}