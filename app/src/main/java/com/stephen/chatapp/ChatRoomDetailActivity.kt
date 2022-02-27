package com.stephen.chatapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.stephen.chatapp.adapter.MessageListAdapter
import com.stephen.chatapp.data.chatroomlist.ChatRoomModel
import com.stephen.chatapp.data.chatroomlist.MessageModel
import com.stephen.chatapp.databinding.ActivityChatRoomDetailBinding
import com.stephen.chatapp.util.Constant
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ua.naiksoftware.stomp.Stomp
import ua.naiksoftware.stomp.dto.LifecycleEvent

class ChatRoomDetailActivity : AppCompatActivity() {

    private val binding: ActivityChatRoomDetailBinding by lazy {
        ActivityChatRoomDetailBinding.inflate(layoutInflater)
    }

    private lateinit var adapter: MessageListAdapter

    private lateinit var chatRoomModel: ChatRoomModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()
        connectSocket()
    }

    private fun initViews() {
        chatRoomModel = intent.getSerializableExtra(ChatRoomModel::class.java.name) as ChatRoomModel
        binding.chatRoomModel = chatRoomModel

        initRecyclerView()
    }

    private fun connectSocket() {

        val stompClient = Stomp.over(Stomp.ConnectionProvider.OKHTTP, Constant.WS_BASE_URL)
        stompClient.connect()

        stompClient.lifecycle().subscribe { lifecycleEvent ->
            when (lifecycleEvent.type) {
                LifecycleEvent.Type.OPENED -> {
                    Log.d("chatRooms", "OPEND")
                }
                LifecycleEvent.Type.CLOSED -> {
                    Log.d("chatRooms", "CLOSED")

                }
                LifecycleEvent.Type.ERROR -> {
                    Log.d("chatRooms", "ERROR")
                    Log.e("CONNECT ERROR", lifecycleEvent.exception.toString())
                }
                else ->{
                    Log.d("chatRooms", "ELSE")
                    Log.d("chatRooms", lifecycleEvent.message)
                }
            }
        }

        stompClient.topic("/sub/chat/room/${chatRoomModel.id}")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
            { message ->
                val message = Gson().fromJson(message.payload, MessageModel::class.java)
                var messages: List<MessageModel> = adapter.currentList
                messages = messages + message
                adapter.submitList(messages)

                Log.d("chatRooms", message.toString())
            }

        binding.apply {
            button.setOnClickListener{
                val message = editText.text.toString()
                if (message.isEmpty()) return@setOnClickListener
                stompClient.send("/pub/chat/room/${chatRoomModel!!.id}",
                    Gson().toJson(MessageModel(message = message, sender = "이우성", type = "TALK"))).subscribe()
                editText.setText("")
            }
        }

    }

    private fun initRecyclerView() {
        adapter = MessageListAdapter()
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(this@ChatRoomDetailActivity)
            recyclerView.adapter = adapter
        }
    }

}