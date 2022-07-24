package com.example.myapplication.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.data.User
import com.example.myapplication.data.UserViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_2.view.*
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await
import okhttp3.internal.wait


class AddFragment : Fragment() {
    private lateinit var mUserViewModel: UserViewModel
    lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         val view = inflater.inflate(R.layout.fragment_2, container, false)
        auth = FirebaseAuth.getInstance()
        auth.signOut()
        view.addUserBtn.setOnClickListener {
            registerUser(view)
        }
        view.addUserBtn2.setOnClickListener {
            loginUser(view)
        }
        return view
    }


    private fun registerUser(view: View) {
        val email = view.regEmailEditText.text.toString()
        val password = view.regPasswordEditText.text.toString()
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(context, "Please enter text in email/password", Toast.LENGTH_SHORT)
                .show()
        } else {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    auth.createUserWithEmailAndPassword(email, password)
                    withContext(Dispatchers.Main) {
                        checkLoggedIn(view)
                    }


                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }

    private fun loginUser(view: View) {
        val email = view.logEmailEditText2.text.toString()
        val password = view.logPasswordEditText.text.toString()
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(context, "Please enter text in email/password", Toast.LENGTH_SHORT)
                .show()
        } else {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    (auth.signInWithEmailAndPassword(email, password)).await()
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }


    private fun checkLoggedIn(view: View) {
        if (auth.currentUser == null) {
        view.authTextView.text = "Not logged in"
        } else {
            view.authTextView.text = "Logged in"
        }
    }

}