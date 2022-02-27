package com.stephen.chatapp.network.repository.chat

import com.stephen.chatapp.data.chatroomlist.ChatRoomModel
import retrofit2.Response

/**
 * Written by StephenLeeDev on 2022/02/15.
 */

interface ChatRepository {
    suspend fun getAllRooms(): Response<List<ChatRoomModel>>
    suspend fun createRoom(name: String): Response<ChatRoomModel>
}