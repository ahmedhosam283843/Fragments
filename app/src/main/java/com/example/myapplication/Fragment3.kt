package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_3.*
import kotlinx.android.synthetic.main.fragment_3.view.*


class Fragment3 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var number = 0
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_3, container, false)
        val viewModel  = ViewModelProvider(this).get(MainClassViewModel::class.java)
        viewModel.seconds().observe(viewLifecycleOwner, Observer {
            view.clickNumber.text = it.toString() })
        viewModel.isFinished().observe(viewLifecycleOwner, Observer{
            if(it)
            Toast.makeText(activity, "Finished", Toast.LENGTH_SHORT).show()
        })
        view.start_btn.setOnClickListener {
            if(view.milliSeconds.text.isEmpty() || view.milliSeconds.text.length <4)
                Toast.makeText(activity, "Invalid Number", Toast.LENGTH_SHORT).show()
            else{
                viewModel.timerValue.value = milliSeconds.text.toString().toLong()
                viewModel.startTimer()
            }
        }
        view.stop_btn.setOnClickListener {
            clickNumber.text = "0"
            viewModel.stopTimer()
        }

        return view
    }

}