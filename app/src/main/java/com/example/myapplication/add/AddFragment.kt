package com.example.myapplication.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.data.User
import com.example.myapplication.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_2.view.*


class AddFragment : Fragment() {
    private lateinit var  mUserViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_2, container, false)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        view.addUserBtn.setOnClickListener {
            insertDataToDatabase(view)
        }
        return view
    }

    private fun insertDataToDatabase(view: View) {
        val firstName = view.firstNameEditText.text.toString()
        val lastName = view.lastNameEditText.text.toString()
        val age = view.ageNameEditText.text.toString()
        if (inputCheck(firstName, lastName, age)) {
            val user  = User(0, firstName, lastName, age.toInt())
            mUserViewModel.addUser(user)
            Toast.makeText(context, "User added", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
        else{
            Toast.makeText(context, "please fill all data", Toast.LENGTH_SHORT).show()
        }
    }
    private fun inputCheck(firstName: String, lastName: String, age: String): Boolean {
        return if (firstName.isEmpty() || lastName.isEmpty() || age.isEmpty()) {
            false
        } else {
            true
        }
    }


}