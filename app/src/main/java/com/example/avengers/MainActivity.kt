package com.example.avengers

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    var titleName:String? ="Avengers"
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scrollview_example)
        println("oncreate called")
        sharedPreferences=getSharedPreferences(getString(R.string.Avengers_preferences), Context.MODE_PRIVATE)

        titleName=sharedPreferences.getString("Title","The Avengers")

        title =titleName
    }


}