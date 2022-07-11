package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import kotlinx.android.synthetic.main.fragment1.view.*
import kotlinx.android.synthetic.main.fragment_2.view.*


class Fragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val view =  inflater.inflate(R.layout.fragment1, container, false)
        addBtn1Listener(view)
        return view
    }

    fun addBtn1Listener(view: View){
//        view.buttonTo2.setOnClickListener {(activity as Communicator).replaceFragmentWithData(view.editText1.text.toString(), Fragment2()) }
        view.buttonTo2.setOnClickListener {
            val action = Fragment1Directions.actionFragment1ToFragment2(view.editText1.text.toString())
            Navigation.findNavController(view).navigate(action)

        }
    }


}