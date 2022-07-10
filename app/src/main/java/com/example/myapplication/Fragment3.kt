package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        view.clickNumber.text = viewModel.number.toString()
        view.button.setOnClickListener {
            viewModel.addNumber()
            view.clickNumber.text = viewModel.number.toString()

        }

        return view
    }

}