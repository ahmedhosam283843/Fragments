package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.User
import kotlinx.android.synthetic.main.my_row.*
import kotlinx.android.synthetic.main.my_row.view.*

class listAdapter (): RecyclerView.Adapter<listAdapter.MyViewHolder>() {
    private var userList = emptyList<User>()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.my_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = userList[position]
        holder.itemView.firstTextView.text = user.firstName
        holder.itemView.secondTextView.text = user.lastName
        holder.itemView.ageTextView.text = user.age.toString()
        holder.itemView.idTextView.text = user.id.toString()

    }
    fun setData(userList: List<User>) {
        this.userList = userList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return userList.size
    }


}