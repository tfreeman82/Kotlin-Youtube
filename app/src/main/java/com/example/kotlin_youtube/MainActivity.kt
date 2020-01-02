package com.example.kotlin_youtube

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //recyclerview_main.setBackgroundColor(Color.BLUE)
        recyclerview_main.layoutManager = LinearLayoutManager(this)
        recyclerview_main.adapter = MainAdapter()
    }
}
