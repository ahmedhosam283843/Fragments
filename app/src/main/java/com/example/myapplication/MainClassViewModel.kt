package com.example.myapplication

import android.content.IntentSender
import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainClassViewModel : ViewModel(){
    private lateinit var timer: CountDownTimer
    private val _seconds  = MutableLiveData<Int>()
    private var finished = MutableLiveData<Boolean>()
    var timerValue = MutableLiveData<Long>()


    fun isFinished() : LiveData<Boolean>{
        return finished
    }
    fun seconds():LiveData<Int>{
        return _seconds
    }
    fun startTimer(){
        timer = object : CountDownTimer(timerValue.value!!.toLong(), 1000){
            override fun onTick(p0: Long) {
                val timeLeft = p0/1000
                _seconds.value = timeLeft.toInt()

            }

            override fun onFinish() {
                finished.value = true
            }

        }.start()
    }
    fun stopTimer(){
        timer.cancel()
    }
}