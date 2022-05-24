package com.example.listweeklyfour.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listweeklyfour.App
import com.example.listweeklyfour.UsersAdapter
import com.example.listweeklyfour.databinding.ActivityMainBinding
import com.example.listweeklyfour.model.UserActionListener
import com.example.listweeklyfour.model.ChatData
import com.example.listweeklyfour.model.UsersListener
import com.example.listweeklyfour.model.UsersService

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UsersAdapter

    private val usersService: UsersService
        get() = (applicationContext as App).usersService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = UsersAdapter(object : UserActionListener {
            override fun onUserMove(user: ChatData, moveBy: Int) {
                usersService.moveUser(user, moveBy)
            }

            override fun onUserDelete(user: ChatData) {
                usersService.deleteUser(user)
            }

            override fun onUserDetails(user: ChatData) {
                val chat = Intent(this@MainActivity, ChatActivity::class.java)
                chat.putExtra("username", user.name)
                chat.putExtra("count", user.count)
                startActivity(chat)
            }

            override fun onUserFire(user: ChatData) {
                usersService.fireUser(user)
            }
        })

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerChats.layoutManager = layoutManager
        binding.recyclerChats.adapter = adapter
        val itemAnimator = binding.recyclerChats.itemAnimator
        if (itemAnimator is DefaultItemAnimator) {
            itemAnimator.supportsChangeAnimations = false
        }
        usersService.addListener(usersListener)
    }

    override fun onDestroy() {
        super.onDestroy()
        usersService.removeListener(usersListener)
    }

    private val usersListener: UsersListener = {
        adapter.users = it
    }
}