package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment1.*
import kotlinx.android.synthetic.main.fragment_2.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(){
    val Tag = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val job = GlobalScope.launch(Dispatchers.Default) {

            Log.d(Tag, "Start Long running application ${Thread.currentThread().name} ")
            withTimeout(3000L){//terminates couroutine if it takes more than 3 seconds
                for (i in 30..50){
                    if (isActive)
                        Log.d(Tag, "Result of Fib for  $i : ${fib(i)}")
                }
            }

            Log.d(Tag, "End Long running application ${Thread.currentThread().name} ")
        }



//        runBlocking { //This will block the thread -> used to call suspend functions
//            delay(2000L)
//            job.cancel()
//            Log.d(Tag, "Cancelling Coroutine ${Thread.currentThread().name} ")
//        }
    }

    private fun fib(i: Int): Long {
        return when (i) {
            0 -> 0
            1 -> 1
            else -> fib(i - 1) + fib(i - 2)
        }
    }

    suspend fun doNetworkCall():String{
        delay(1000L)
        return "Hello"
    }
    suspend fun doNetworkCall2():String{
        delay(1000L)
        return "Hello"
    }

}