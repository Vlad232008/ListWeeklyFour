package com.example.listweeklyfour.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listweeklyfour.databinding.ActivityChatBinding
import com.example.listweeklyfour.model.ChatAdapter
import com.github.javafaker.Faker


class ChatActivity : AppCompatActivity() {
    val data = mutableListOf<String>()
    private var countMessage = 0
    var call = 0
    var countSMS = 0
    private lateinit var binding: ActivityChatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val count = intent.getIntExtra("count", 0)
        countSMS = count
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRcV()
        binding.swipeRefreshLayout.setOnRefreshListener {
            initRcV()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun initRcV() = with(binding) {
        val user = intent.getStringExtra("username")
        val adapter = ChatAdapter(fillList(), user!!)
        rcView.layoutManager = LinearLayoutManager(this@ChatActivity)
        rcView.adapter = adapter
    }

    private fun fillList(): List<String> {
        if (countSMS > 10) {
            countMessage = 10
            //(0 until countMessage).forEach { i -> data.add(faker.address().country()) }
            (0 until countMessage).forEach { i -> data.add(call++.toString()) }
            countSMS -= 10
        }
        //else (0 until count).forEach { i -> data.add(faker.address().country()) }
        else {
            if(countSMS == 0) {
                return data
            }
            (0 until countSMS).forEach { i -> data.add(call++.toString()) }
            countSMS = 0
        }
        return data
    }
}