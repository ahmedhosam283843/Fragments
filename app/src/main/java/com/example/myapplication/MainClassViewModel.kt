package com.example.myapplication

import androidx.lifecycle.ViewModel

class MainClassViewModel : ViewModel(){
    var number = 0
    fun addNumber(){
        number++
    }
}