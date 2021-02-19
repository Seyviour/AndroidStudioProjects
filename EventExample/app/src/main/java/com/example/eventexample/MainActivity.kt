package com.example.eventexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.MotionEvent
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activity_main.setOnTouchListener { _, m: MotionEvent ->
            handleTouch(m)
            true
        }





        /**
        myButton.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                TODO("Not yet implemented")
            }
        }) **/

        myButton.setOnClickListener {
            statusText.text = "Button Clicked"
        }

        myButton.setOnLongClickListener {
            statusText.text = "Long button click"
            false

        }
    }
    private fun handleTouch(m: MotionEvent)
    {
        val pointerCount = m.pointerCount

        for (i in 0 until pointerCount)
        {
            val x = m.getX(i)
            val y = m.getY(i)
            val id = m.getPointerId(i)
            val action = m.actionMasked
            val actionIndex = m.actionIndex

            var actionString: String

            actionString = when (action) {
                MotionEvent.ACTION_DOWN -> "DOWN"
                MotionEvent.ACTION_UP -> "UP"
                MotionEvent.ACTION_POINTER_DOWN -> "PNTR DOWN"
                MotionEvent.ACTION_POINTER_UP -> "PNTR UP"
                MotionEvent.ACTION_MOVE -> "MOVE"
                else -> ""
            }

            val touchStatus = "Action: $actionString Index: $actionIndex ID: $id x:$x y:$y"

            if (id == 0)
                textView1.text = touchStatus
            else
                textView2.text = touchStatus
        }
    }
}