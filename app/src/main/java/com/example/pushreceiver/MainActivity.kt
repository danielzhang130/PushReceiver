package com.example.pushreceiver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import com.google.firebase.messaging.FirebaseMessaging
import com.google.android.gms.tasks.OnSuccessListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageView = ImageView(this)
        setContentView(imageView)
        FirebaseMessaging.getInstance().apply {
            token.addOnSuccessListener { s: String? ->
                Log.d("", s.orEmpty())
                val encoder = QRGEncoder(s, QRGContents.Type.TEXT, 500)
                val bitmap = encoder.bitmap
                imageView.setImageBitmap(bitmap)
            }
        }
    }
}