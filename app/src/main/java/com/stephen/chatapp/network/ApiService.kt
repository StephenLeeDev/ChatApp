package com.stephen.chatapp.network

import com.stephen.chatapp.data.auth.UserModel
import com.stephen.chatapp.data.auth.UserRequestModel
import com.stephen.chatapp.data.chatroomlist.ChatRoomModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Written by StephenLeeDev on 2022/02/15.
 */

interface ApiService {

    @GET("/api/v1/chat/room")
    suspend fun getAllRooms(): Response<List<ChatRoomModel>>

    @POST("/api/v1/chat/room")
    suspend fun createRoom(@Query("name") name: String): Response<ChatRoomModel>

    @POST("/api/v1/user")
    suspend fun createUser(@Query("userRequest") userRequest: UserRequestModel): Response<UserModel>

}