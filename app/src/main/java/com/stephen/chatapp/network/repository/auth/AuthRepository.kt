package com.stephen.chatapp.network.repository.auth

import com.stephen.chatapp.data.auth.UserModel
import com.stephen.chatapp.data.auth.UserRequestModel
import com.stephen.chatapp.data.chatroomlist.ChatRoomModel
import retrofit2.Response

/**
 * Written by StephenLeeDev on 2022/02/15.
 */

interface AuthRepository {
    suspend fun createUser(userRequest: UserRequestModel): Response<UserModel>
}