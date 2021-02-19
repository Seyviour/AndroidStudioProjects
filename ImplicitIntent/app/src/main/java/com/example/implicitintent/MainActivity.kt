package com.example.implicitintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.net.Uri
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openWebsite(view: View){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/seyviour"))
        startActivity(intent)
    }
}