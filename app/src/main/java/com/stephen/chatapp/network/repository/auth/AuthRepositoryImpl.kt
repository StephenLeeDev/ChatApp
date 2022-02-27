package com.stephen.chatapp.network.repository.auth

import com.stephen.chatapp.data.auth.UserModel
import com.stephen.chatapp.data.auth.UserRequestModel
import com.stephen.chatapp.data.chatroomlist.ChatRoomModel
import com.stephen.chatapp.network.ApiService
import retrofit2.Response
import javax.inject.Inject

/**
 * Written by StephenLeeDev on 2022/02/15.
 */

class AuthRepositoryImpl @Inject constructor(private val apiService: ApiService) : AuthRepository {
    override suspend fun createUser(userRequest: UserRequestModel): Response<UserModel> = apiService.createUser(userRequest = userRequest)
}