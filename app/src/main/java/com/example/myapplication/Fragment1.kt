package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.fragment1.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class Fragment1 : Fragment() {
//    private lateinit var communicator: Communicator
//    var msg: String? = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val view =  inflater.inflate(R.layout.fragment1, container, false)

//        msg = arguments?.getString("message")
//        view.textView1.text = msg
        view.buttonTo2.setOnClickListener {
            (activity as Communicator).replaceFragmentWithData(view.editText1.text.toString(), Fragment2())
        }
        return view
    }



}