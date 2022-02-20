package com.stephen.chatapp.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stephen.chatapp.data.chatroomlist.ChatRoomModel
import com.stephen.chatapp.network.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Written by StephenLeeDev on 2022/02/15.
 */

@HiltViewModel
class ChatRoomViewModel @Inject constructor(private val mainRepository: MainRepository) :
    ViewModel() {

    val chatRooms = MutableLiveData<List<ChatRoomModel>>()

    fun fetchAllRooms() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = mainRepository.getAllRooms()
            if (response.isSuccessful) {
                chatRooms.postValue(response.body())
            }
        }
    }

    fun createRoom(name: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = mainRepository.createRoom(name = name)
            if (response.isSuccessful) {
                fetchAllRooms()
            }
        }
    }
}