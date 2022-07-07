package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment1.view.*
import kotlinx.android.synthetic.main.fragment_2.*
import kotlinx.android.synthetic.main.fragment_2.view.*


class Fragment2 : Fragment() {
    // TODO: Rename and change types of parameters

    var msg: String? = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_2, container, false)
        changeTextView(view)
        addBtn1Listener(view)
        return view
    }

    fun changeTextView(view: View){
        msg = arguments?.getString("message")
        view.textView2.text = msg
    }
    fun addBtn1Listener(view: View){
        view.buttonTo1.setOnClickListener {
            (activity as Communicator).replaceFragmentWithData(view.textView2.text.toString(), Fragment1())
        }
    }

}