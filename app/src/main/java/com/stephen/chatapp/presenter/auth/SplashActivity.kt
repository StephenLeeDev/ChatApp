package com.stephen.chatapp.presenter.auth

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.stephen.chatapp.base.BaseActivity
import com.stephen.chatapp.databinding.ActivitySplashBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {

    private val binding: ActivitySplashBinding by lazy { ActivitySplashBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        lifecycleScope.launch(Dispatchers.Main) {
            delay(2000)
            // TODO : 토큰 보유 확인 후 로그인 화면 or 메인 화면 분기 처리
            startActivity(Intent(this@SplashActivity, SignUpActivity::class.java))
        }
    }

}