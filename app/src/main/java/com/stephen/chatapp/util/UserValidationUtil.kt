package com.stephen.chatapp.util

import android.util.Patterns

/**
 * Written by StephenLeeDev on 2022/02/27.
 */

object UserValidationUtil {

 fun validationPassword(password: String, confirmPassword: String): Boolean = password == confirmPassword

 fun validationEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

}