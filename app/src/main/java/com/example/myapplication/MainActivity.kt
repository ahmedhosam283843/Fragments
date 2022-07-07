package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment1.*
import kotlinx.android.synthetic.main.fragment_2.*

class MainActivity : AppCompatActivity()/*, Communicator */{
    lateinit var s1 : Array<String>
    lateinit var s2 : Array<String>
    val imgs = listOf<Int>(
        androidx.customview.R.drawable.notification_bg, androidx.constraintlayout.widget.R.drawable.abc_ab_share_pack_mtrl_alpha,
    androidx.viewpager.R.drawable.notification_bg, androidx.constraintlayout.widget.R.drawable.notification_bg, androidx.appcompat.R.drawable.abc_ic_go_search_api_material,
        androidx.constraintlayout.widget.R.drawable.notification_bg, androidx.transition.R.drawable.abc_btn_check_to_on_mtrl_000, androidx.constraintlayout.widget.R.drawable.abc_spinner_textfield_background_material,
        androidx.constraintlayout.widget.R.drawable.notification_bg, androidx.appcompat.R.drawable.abc_edit_text_material)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        s1 = resources.getStringArray(R.array.programming_languages)
        s2 = resources.getStringArray(R.array.description)


        val adapter = Adapter(this, s1, s2, imgs)

        recycleView.adapter = adapter
        recycleView.layoutManager  = LinearLayoutManager(this)


//      val frag1  = Fragmnet1()
//        replaceFragment(frag1)
    }


//    fun createBundle(txt: String): Bundle{
//        val bundle = Bundle()
//        bundle.putString("message",txt)
//        return bundle
//    }
//
//    fun createFrag(editTextInput: String, fragment: Fragment):Fragment{
//        val bundle = createBundle(editTextInput)
//        fragment.arguments = bundle
//        return fragment
//    }
//    fun replaceFragment(fragment: Fragment){
//        supportFragmentManager.beginTransaction().replace(R.id.frag, fragment).commit()
//    }
//
//    override fun replaceFragmentWithData(editTextInput: String, fragment: Fragment) {
//        var modifiedFrag = createFrag(editTextInput, fragment)
//        replaceFragment(modifiedFrag)
//    }
}