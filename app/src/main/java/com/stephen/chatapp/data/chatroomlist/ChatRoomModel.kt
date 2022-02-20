package com.stephen.chatapp.data.chatroomlist


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ChatRoomModel(
    @SerializedName("id")
    val id: String
): Serializable