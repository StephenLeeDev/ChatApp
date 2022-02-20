package com.stephen.chatapp.network

import com.stephen.chatapp.data.chatroomlist.ChatRoomModel
import retrofit2.Response
import javax.inject.Inject

/**
 * Written by StephenLeeDev on 2022/02/15.
 */

class MainRepositoryImpl @Inject constructor(private val apiService: ApiService) : MainRepository {
    override suspend fun getAllRooms() = apiService.getAllRooms()
    override suspend fun createRoom(name: String): Response<ChatRoomModel> = apiService.createRoom(name = name)
}