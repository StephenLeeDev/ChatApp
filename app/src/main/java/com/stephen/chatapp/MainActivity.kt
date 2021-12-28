package com.stephen.chatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.stephen.chatapp.databinding.ActivityMainBinding
import com.stephen.chatapp.util.Constant
import dagger.hilt.android.AndroidEntryPoint
import io.socket.client.IO
import io.socket.client.Socket
import io.socket.emitter.Emitter

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var mSocket: Socket

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()

        try {
            /**
             * Constant.BASE_URL is "http://Your IP Address:3000"
             * ex) "http://192.168.111.111:3000"
             */
            mSocket = IO.socket(Constant.BASE_URL)
            Log.d("mSocket", mSocket.toString())

        } catch (e: Exception) {
            e.printStackTrace()
            Log.d("mSocket", "Failed to connect")
        }

        mSocket.connect()
        mSocket.on(Socket.EVENT_CONNECT, onConnect)
        mSocket.on("message", onReceive)
    }

    private val onConnect: Emitter.Listener = Emitter.Listener {
        mSocket.emit("connectReceive", "Socket connected")
        Log.d("mSocket", "Socket connected")
    }

    var onReceive = Emitter.Listener {
        Log.d("mSocket", "onReceive")
    }

    private fun initView() {
        binding.apply {
            button.setOnClickListener {
                mSocket.emit("connection", "Socket connected")
            }
        }
        binding.apply {
            button2.setOnClickListener {
                mSocket.emit("message", "Socket message")
            }
        }
    }

}