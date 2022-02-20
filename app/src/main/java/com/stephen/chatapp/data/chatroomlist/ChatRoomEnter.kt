package com.stephen.chatapp.data.chatroomlist


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ChatRoomEnter(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
): Serializable