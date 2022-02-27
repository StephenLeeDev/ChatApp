package com.stephen.chatapp.data.auth


import com.google.gson.annotations.SerializedName

data class UserRequestModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("nickName")
    val nickName: String,
    @SerializedName("password")
    val password: String
)