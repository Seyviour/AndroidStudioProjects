package com.example.explicitintent

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val request_code = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if((requestCode == request_code) && (resultCode== Activity.RESULT_OK)){
            data?.let{
                if (it.hasExtra("returnData")){
                    val returnString = it.extras?.getString("returnData")
                    textView1.text=returnString
                }}
        }
    }

    fun sendText(view:View) {
        val i = Intent(this, ActivityB::class.java)
        val myString = editText1.text.toString()
        i.putExtra("qString", myString)
        startActivityForResult(i, request_code)
    }
}