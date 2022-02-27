package com.stephen.chatapp.data.auth

import com.google.gson.annotations.SerializedName

/**
 * Written by StephenLeeDev on 2022/02/27.
 */

data class UserModel(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("nickName")
    val nickName: String,
    @SerializedName("password")
    val password: String?,
)