package com.example.listweeklyfour.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listweeklyfour.databinding.ActivityChatBinding
import com.example.listweeklyfour.model.ChatAdapter
import com.github.javafaker.Faker


class ChatActivity : AppCompatActivity() {
    val faker = Faker.instance()
    private lateinit var binding: ActivityChatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRcV()
    }
    private fun initRcV() = with(binding){
        val adapter = ChatAdapter(fillList())
        rcView.layoutManager = LinearLayoutManager(this@ChatActivity)
        rcView.adapter = adapter
    }

    private fun fillList(): List<String> {
        val intent = intent
        val count = intent.getIntExtra("count",0)
        val data = mutableListOf<String>()
        (0 until count).forEach { i -> data.add(faker.address().country()) }
        return data
    }
}