package com.example.pushreceiver

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageView = ImageView(this)
        setContentView(imageView)
        FirebaseMessaging.getInstance().apply {
            token.addOnSuccessListener { s: String? ->
                Log.d(this@MainActivity.toString(), s.orEmpty())
                val encoder = QRGEncoder(s, QRGContents.Type.TEXT, 500)
                val bitmap = encoder.bitmap
                imageView.setImageBitmap(bitmap)
            }
        }
    }
}