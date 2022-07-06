package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment1.*
import kotlinx.android.synthetic.main.fragment_2.*

class MainActivity : AppCompatActivity(), Communicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val frag1 = Fragment1()
        replaceFragment(frag1)
    }
    fun createBundle(txt: String): Bundle{
        val bundle = Bundle()
        bundle.putString("message",txt)
        return bundle
    }

    fun createFrag(bundle: Bundle, fragment: Fragment):Fragment{
        fragment.arguments = bundle
        return fragment
    }
    fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frag, fragment).commit()
    }

    override fun replaceFragmentWithData(editTextInput: String, fragment: Fragment) {
        val bundle = createBundle(editTextInput)
        val fragment = createFrag(bundle, fragment)
        replaceFragment(fragment)
    }
}