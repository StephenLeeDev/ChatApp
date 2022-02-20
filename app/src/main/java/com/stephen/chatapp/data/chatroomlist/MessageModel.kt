package com.stephen.chatapp.data.chatroomlist


import com.google.gson.annotations.SerializedName

data class MessageModel(
    @SerializedName("message")
    val message: String,
    @SerializedName("sender")
    val sender: String,
    @SerializedName("type")
    val type: String
)