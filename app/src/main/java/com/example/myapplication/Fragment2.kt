package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment1.view.*
import kotlinx.android.synthetic.main.fragment_2.*
import kotlinx.android.synthetic.main.fragment_2.view.*


class Fragment2 : Fragment() {
    val args: Fragment2Args by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_2, container, false)
        val msg = args.message.toString()
        view.textView2.text = msg

        addBtn2Listener(view)

        return view
    }


    fun addBtn2Listener(view: View){
//        view.buttonTo1.setOnClickListener {(activity as Communicator).replaceFragmentWithData(view.textView2.text.toString(), Fragment1()) }
        view.buttonTo1.setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_fragment2_to_fragment1) }

    }

}