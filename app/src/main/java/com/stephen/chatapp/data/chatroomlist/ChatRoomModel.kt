package com.stephen.chatapp.data.chatroomlist


import com.google.gson.annotations.SerializedName
import com.stephen.chatapp.data.auth.UserModel
import java.io.Serializable

data class ChatRoomModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("userList")
    val userList: List<UserModel>,
): Serializable