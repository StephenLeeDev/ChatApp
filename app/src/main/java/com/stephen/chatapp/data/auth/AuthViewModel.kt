package com.stephen.chatapp.data.auth

import androidx.lifecycle.ViewModel
import com.stephen.chatapp.network.repository.auth.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Written by StephenLeeDev on 2022/02/27.
 */

@HiltViewModel
class AuthViewModel @Inject constructor(private val authRepository: AuthRepository) : ViewModel() {

    fun createUser(userRequestModel: UserRequestModel) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = authRepository.createUser(userRequest = userRequestModel)
            if (response.isSuccessful) {

            }
        }
    }
}