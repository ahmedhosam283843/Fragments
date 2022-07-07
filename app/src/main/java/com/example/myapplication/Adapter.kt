package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.my_row.*
import kotlinx.android.synthetic.main.my_row.view.*

class Adapter (val ct: Context, var s1: Array<String>, var s2: Array<String>, val imgs: List<Int>): RecyclerView.Adapter<Adapter.MyViewHolder>() {


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView ) {
        val myText1 = itemView.lang_name
        val myText2 = itemView.langDescription
        val imageView = itemView.langImage
        val rowLayout = itemView.rowLayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater  = LayoutInflater.from(ct)
        val view  = inflater.inflate(R.layout.my_row, parent, false)
        return MyViewHolder(view)
     }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.imageView.setImageResource(imgs[position])
        holder.myText1.setText(s1[position])
        holder.myText2.setText(s2[position])
        holder.rowLayout.setOnClickListener{
            var intent = Intent(ct, language::class.java)
            intent.putExtra("data1", s1[position])
            intent.putExtra("data2", s2[position])
            intent.putExtra("image", imgs[position])
            ct.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
           return s1.size
    }
}