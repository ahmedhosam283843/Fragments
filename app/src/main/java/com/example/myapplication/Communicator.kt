package com.example.myapplication

import androidx.fragment.app.Fragment

interface Communicator {
     fun replaceFragmentWithData(editTextInput: String, fragment: Fragment)
}