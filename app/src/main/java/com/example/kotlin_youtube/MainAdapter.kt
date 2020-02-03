package com.example.kotlin_youtube

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.video_row.view.*

class MainAdapter(val homeFeed: HomeFeed): RecyclerView.Adapter<YoutubeViewHolder>() {
    val videoTitles = listOf<String>("First title", "Second", "Third")

    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YoutubeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)

        return YoutubeViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: YoutubeViewHolder, position: Int) {
        val video = homeFeed.videos.get(position)
        holder.view.textView_vido_title?.text= video.name
    }
}

class YoutubeViewHolder(val view: View): RecyclerView.ViewHolder(view) {

}