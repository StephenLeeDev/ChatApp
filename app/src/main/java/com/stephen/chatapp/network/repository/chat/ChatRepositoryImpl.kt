package com.stephen.chatapp.network.repository.chat

import com.stephen.chatapp.data.chatroomlist.ChatRoomModel
import com.stephen.chatapp.network.ApiService
import retrofit2.Response
import javax.inject.Inject

/**
 * Written by StephenLeeDev on 2022/02/15.
 */

class ChatRepositoryImpl @Inject constructor(private val apiService: ApiService) : ChatRepository {
    override suspend fun getAllRooms() = apiService.getAllRooms()
    override suspend fun createRoom(name: String): Response<ChatRoomModel> = apiService.createRoom(name = name)
}