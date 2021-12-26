package com.stephen.chatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.stephen.chatapp.databinding.ActivityMainBinding
import com.stephen.chatapp.util.Constant
import dagger.hilt.android.AndroidEntryPoint
import io.socket.client.IO
import io.socket.client.Socket

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var mSocket: Socket

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        try {
            /**
             * Constant.BASE_URL is "http://Your IP Address:3000"
             */
            mSocket = IO.socket(Constant.BASE_URL)
            Log.d("mSocket", mSocket.toString())

        } catch (e: Exception) {
            e.printStackTrace()
            Log.d("mSocket", "Failed to connect")
        }

        mSocket.connect()

    }
}