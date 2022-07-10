package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment1.*
import kotlinx.android.synthetic.main.fragment_2.*

class MainActivity : AppCompatActivity(){
//    lateinit var s1 : Array<String>
//    lateinit var s2 : Array<String>
//    val imgs = listOf<Int>(
//        androidx.customview.R.drawable.notification_bg, androidx.constraintlayout.widget.R.drawable.abc_ab_share_pack_mtrl_alpha,
//    androidx.viewpager.R.drawable.notification_bg, androidx.constraintlayout.widget.R.drawable.notification_bg, androidx.appcompat.R.drawable.abc_ic_go_search_api_material,
//        androidx.constraintlayout.widget.R.drawable.notification_bg, androidx.transition.R.drawable.abc_btn_check_to_on_mtrl_000, androidx.constraintlayout.widget.R.drawable.abc_spinner_textfield_background_material,
//        androidx.constraintlayout.widget.R.drawable.notification_bg, androidx.appcompat.R.drawable.abc_edit_text_material)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        s1 = resources.getStringArray(R.array.programming_languages)
//        s2 = resources.getStringArray(R.array.description)
//        val adapter = Adapter(this, s1, s2, imgs)
//        recycleView.adapter = adapter
//        recycleView.layoutManager  = LinearLayoutManager(this)


    }

}