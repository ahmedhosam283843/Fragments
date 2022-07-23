package com.example.myapplication.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.data.UserViewModel
import com.example.myapplication.listAdapter
import kotlinx.android.synthetic.main.fragment1.view.*


class ListFragment : Fragment() {
    private lateinit var mViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment1, container, false)
        val recyclerView = view.recyclerView
        val adapter = listAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        mViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        mViewModel.readAllData.observe(viewLifecycleOwner) { user ->
            adapter.setData(user)
        }
        view.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }


        return view
    }



}