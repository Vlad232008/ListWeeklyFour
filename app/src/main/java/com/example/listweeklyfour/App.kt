package com.example.listweeklyfour

import android.app.Application
import com.example.listweeklyfour.model.UsersService

class App : Application() {
    val usersService = UsersService()
}