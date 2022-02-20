package com.stephen.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.stephen.chatapp.adapter.RoomListAdapter
import com.stephen.chatapp.data.ChatRoomViewModel
import com.stephen.chatapp.data.chatroomlist.ChatRoomModel
import com.stephen.chatapp.databinding.ActivityMainBinding
import com.stephen.chatapp.interfaces.ClickEventListener
import com.stephen.chatapp.util.AppUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var adapter: RoomListAdapter

    private val chatRoomViewModel : ChatRoomViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        chatRoomViewModel.chatRooms.observe(this) {
            adapter.submitList(it)
        }

//        SocketHandler.setSocket()
//        SocketHandler.establishConnection()
//
//        val mSocket = SocketHandler.getSocket()
//
//        binding.counterBtn.setOnClickListener{
//            Log.d("chatRooms", "clicked")
//            mSocket.emit("/sub/chat/room/room_김동현")
//        }
//
//        mSocket.on("/sub/chat/room/room_김동현") { args ->
//            if (args[0] != null) {
//                Log.d("chatRooms", args.toString())
//                val counter = args[0] as Int
//                runOnUiThread {
//                    binding.countTextView.text = counter.toString()
//                }
//            }
//        }

        initViews()
    }

    private fun initViews() {
        initRecyclerView()
        initCreateRoomViews()
    }

    private fun initRecyclerView() {
        adapter = RoomListAdapter(object : ClickEventListener<ChatRoomModel> {
            override fun onClick(t: ChatRoomModel) {
                startActivity(Intent(this@MainActivity, ChatRoomDetailActivity::class.java).putExtra(ChatRoomModel::class.java.name, t))
            }
        })
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = adapter
        }

        chatRoomViewModel.fetchAllRooms()
    }

    private fun initCreateRoomViews() {
        binding.apply {
            button.setOnClickListener {
                val roomName = editText.text.toString()
                if (roomName.isEmpty()) {
                    AppUtil.showToast(this@MainActivity, getString(R.string.please_enter_chat_room_name))
                }
                chatRoomViewModel.createRoom(roomName)
            }
        }
    }
}