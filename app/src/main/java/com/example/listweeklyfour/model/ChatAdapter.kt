package com.example.listweeklyfour.model

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listweeklyfour.R
import com.example.listweeklyfour.manage.TimeManager
import com.github.javafaker.Faker
import java.util.*

class ChatAdapter(private val names: List<String>, private val user: String) : RecyclerView
.Adapter<ChatAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val message: TextView = itemView.findViewById(R.id.message)
        val user: TextView = itemView.findViewById(R.id.username)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val random = Random()
        if (random.nextInt(2) >= 1) {
            holder.message.text = names[position]
            holder.message.gravity = Gravity.START
            holder.user.text = user
            holder.user.gravity = Gravity.START
            //holder.time.text = TimeManager.getCurrentTime()
        } else {
            holder.message.text = names[position]
            holder.message.gravity = Gravity.END
            holder.user.text = "Я"
            holder.user.gravity = Gravity.END
        }
        //holder.time.text = TimeManager.getCurrentTime()
    }

    override fun getItemCount() = names.size
}