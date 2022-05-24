package com.example.listweeklyfour.model

interface UserActionListener {

    fun onUserMove(user: ChatData, moveBy: Int)

    fun onUserDelete(user: ChatData)

    fun onUserDetails(user: ChatData)

    fun onUserFire(user: ChatData)
}
