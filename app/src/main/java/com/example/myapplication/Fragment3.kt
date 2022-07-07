package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        view.button.setOnClickListener {
            number++
            clickNumber.text = number.toString()
        }

        return view
    }

}