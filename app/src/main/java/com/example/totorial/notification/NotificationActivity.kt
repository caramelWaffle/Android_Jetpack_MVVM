package com.example.totorial.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.databinding.DataBindingUtil
import com.example.totorial.R
import com.example.totorial.databinding.ActivityNotificationBinding

class NotificationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotificationBinding
    private lateinit var notificationManager: NotificationManager
    private val channelId = "com.example.totorial.notification"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_notification)
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        buildNotification(channelId, "MVVM Channel", "This is demo")
        binding.btnNotification.setOnClickListener {
            displayNotification()
        }
    }

    private fun displayNotification() {
        val notificationId = 1
        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle("Demo Title")
            .setContentText("This is content text")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setAutoCancel(true).apply {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    setPriority(NotificationManager.IMPORTANCE_HIGH)
                }
            }.build()

        notificationManager.notify(notificationId, notification)
    }

    private fun buildNotification(id: String, name: String, channelDes: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH).apply {
                description = channelDes
            }
            notificationManager.createNotificationChannel(channel)
        }

    }

}