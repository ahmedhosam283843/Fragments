package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_language.*

class language : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)
        getData()
        setData()
    }

    lateinit var s1: String
    lateinit var s2: String
    var img: Int = 0


    fun getData(){
        if(intent.hasExtra("image") && intent.hasExtra("data2")  && intent.hasExtra("data1") ){
            s1 = intent.getStringExtra("data1").toString()
            s2 = intent.getStringExtra("data2").toString()
            img = intent.getIntExtra("image", 1)
        }
        else{
            Toast.makeText(this, "Missing Data", Toast.LENGTH_SHORT).show()
        }
    }
    fun setData(){
        lang2_title.text = s1
        lang2_description.text = s2
        lang2Image.setImageResource(img)


    }
}