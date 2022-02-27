package com.stephen.chatapp.network.repository

import com.stephen.chatapp.network.repository.auth.AuthRepository
import com.stephen.chatapp.network.repository.auth.AuthRepositoryImpl
import com.stephen.chatapp.network.repository.chat.ChatRepository
import com.stephen.chatapp.network.repository.chat.ChatRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Written by StephenLeeDev on 2022/02/15.
 */

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoriesModule {

    @Binds
    fun chatRepository(chatRepositoryImpl: ChatRepositoryImpl): ChatRepository

    @Binds
    fun authRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository

}