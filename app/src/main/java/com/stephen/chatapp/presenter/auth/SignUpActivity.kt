package com.stephen.chatapp.presenter.auth

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.stephen.chatapp.R
import com.stephen.chatapp.base.BaseActivity
import com.stephen.chatapp.data.auth.AuthViewModel
import com.stephen.chatapp.data.auth.UserRequestModel
import com.stephen.chatapp.databinding.ActivitySignUpBinding
import com.stephen.chatapp.util.AppUtil
import com.stephen.chatapp.util.UserValidationUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : BaseActivity() {

    private val binding: ActivitySignUpBinding by lazy { ActivitySignUpBinding.inflate(layoutInflater) }

    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        binding.apply {
            buttonBack.setOnClickListener {
                finish()
            }

            buttonSignUp.setOnClickListener {
                val name = editTextName.text.toString()
                val email = editTextEmail.text.toString()
                val password = editTextPassword.text.toString()
                val confirmPassword = editTextConfirmPassword.text.toString()

                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    AppUtil.showToast(this@SignUpActivity, getString(R.string.please_fill_out_all_fields), Toast.LENGTH_SHORT)
                    return@setOnClickListener
                }
                else if (!UserValidationUtil.validationEmail(email)) {
                    AppUtil.showToast(this@SignUpActivity, getString(R.string.please_enter_valid_email_address), Toast.LENGTH_SHORT)
                    return@setOnClickListener
                }

                if (!UserValidationUtil.validationPassword(password, confirmPassword)) {
                    AppUtil.showToast(this@SignUpActivity, getString(R.string.password_not_matching), Toast.LENGTH_SHORT)
                } else {
                    // TODO : request create user
                    requestCreateUser(
                        UserRequestModel(id = email, name = name, nickName = name, password = password)
                    )
                }
            }
        }
    }

    private fun requestCreateUser(userRequestModel: UserRequestModel) =
        authViewModel.createUser(userRequestModel)

}