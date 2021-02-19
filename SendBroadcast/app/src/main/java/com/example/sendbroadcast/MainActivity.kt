package com.example.sendbroadcast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.content.IntentFilter
import android.content.BroadcastReceiver

class MainActivity : AppCompatActivity() {

    var receiver: BroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureReceiver()
    }

    fun broadcastIntent(view: View) {
        val intent = Intent()
        intent.action = "com.example.sendbroadcast"
        intent.flags = Intent.FLAG_INCLUDE_STOPPED_PACKAGES
        sendBroadcast(intent)
    }

    private fun configureReceiver(){
        val filter = IntentFilter()
        filter.addAction("com.example.sendbroadcast")
        filter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED")
        filter.addAction("android.intent.action.HEADSET_PLUG")
        receiver = MyReceiver()
        registerReceiver(receiver, filter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}