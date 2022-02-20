package com.stephen.chatapp.util

import android.content.Context
import android.net.Uri
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

object AppUtil {

    private lateinit var toast: Toast

    fun showToast(
        context: Context,
        message: String
    ) {
        if (!this::toast.isInitialized) toast = Toast(context)
        toast.cancel()
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
        toast.show()
    }
}