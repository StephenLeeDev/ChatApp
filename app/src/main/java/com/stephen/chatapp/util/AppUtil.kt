package com.stephen.chatapp.util

import android.content.Context
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

object AppUtil {

    private lateinit var toast: Toast

    fun showToast(
        context: Context,
        message: String,
        toastLength: Int
    ) {
        if (!this::toast.isInitialized) toast = Toast(context)
        toast.cancel()
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast = Toast.makeText(context, message, toastLength)
        toast.show()
    }

//    fun showSnackbar(view : View, title: String, activity: AppCompatActivity): Snackbar {
//        val snackbar = Snackbar.make(view, "", 2000)
//
//        val snackView = activity.layoutInflater.inflate(R.layout.base_snackbar, null)
//        val titleView = snackView.findViewById<TextView>(R.id.text_title)
//        titleView.text = title
//
//        val snackBarView = snackbar.view as Snackbar.SnackbarLayout
//        snackBarView.elevation = 0f
//        snackbar.setBackgroundTint(Color.TRANSPARENT)
//        val parentParams = snackBarView.layoutParams as FrameLayout.LayoutParams
//        parentParams.setMargins(20.dp.toInt(), 20.dp.toInt(), 20.dp.toInt(), 0)
//        parentParams.width = FrameLayout.LayoutParams.MATCH_PARENT
//        parentParams.gravity = Gravity.TOP
//        snackBarView.layoutParams = parentParams
//        snackBarView.addView(snackView, 0)
//        return snackbar
//    }
}