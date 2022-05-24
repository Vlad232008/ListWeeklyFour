package com.example.listweeklyfour.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listweeklyfour.R
import com.example.listweeklyfour.manage.TimeManager

class ChatAdapter(private val names: List<String>) : RecyclerView
.Adapter<ChatAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val message: TextView = itemView.findViewById(R.id.message)
        val user: TextView = itemView.findViewById(R.id.username)
        val time:TextView = itemView.findViewById(R.id.tvTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.message.text = names[position]
        holder.user.text = "кот"
        holder.time.text = TimeManager.getCurrentTime()
    }

    override fun getItemCount() = names.size
}