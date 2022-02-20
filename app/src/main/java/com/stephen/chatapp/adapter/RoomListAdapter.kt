package com.stephen.chatapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stephen.chatapp.data.chatroomlist.ChatRoomModel
import com.stephen.chatapp.databinding.ItemChatRoomBinding
import com.stephen.chatapp.interfaces.ClickEventListener
import javax.inject.Inject

/**
 * Written by StephenLeeDev on 2022/02/20.
 */

class RoomListAdapter(private val listener: ClickEventListener<ChatRoomModel>) :
    ListAdapter<ChatRoomModel, RoomListAdapter.ChatRoomViewHolder>(diffUtil) {

    inner class ChatRoomViewHolder(private val binding: ItemChatRoomBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(chatRoom: ChatRoomModel) {
            binding.apply {
                chatRoomModel = chatRoom
                root.setOnClickListener { listener.onClick(chatRoom) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatRoomViewHolder {
        return ChatRoomViewHolder(
            ItemChatRoomBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ChatRoomViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ChatRoomModel>() {
            override fun areItemsTheSame(oldItem: ChatRoomModel, newItem: ChatRoomModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ChatRoomModel, newItem: ChatRoomModel): Boolean {
                return oldItem == newItem
            }

        }
    }
}