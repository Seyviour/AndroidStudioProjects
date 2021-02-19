package com.example.customgestures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.gesture.GestureLibraries
import android.gesture.GestureLibrary
import android.gesture.GestureOverlayView
import android.gesture.GestureOverlayView.OnGesturePerformedListener

import android.widget.Toast
import android.gesture.Gesture

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnGesturePerformedListener {

    var gLibrary: GestureLibrary? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gestureSetup()
    }

    override fun onGesturePerformed(overlay: GestureOverlayView?, gesture: Gesture?) {
        val predictions = gLibrary?.recognize(gesture)

        predictions?.let {
            if (it.size > 0 && it [0].score > 1.0) {
                val action = it[0].name
                Toast.makeText(this, action, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun gestureSetup() {
        gLibrary = GestureLibraries.fromRawResource(this, R.raw.gestures)
        if (gLibrary?.load() == false) {
            finish()
        }
        gOverlay.addOnGesturePerformedListener(this)
    }


}