package com.globe.forms

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvHello: TextView
    private lateinit var btnResetPage: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvHello = findViewById(R.id.tvHello)
        btnResetPage = findViewById(R.id.btnResetPage)

        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")

        tvHello.text = "hello $email"

        Log.d("MainActivity","$email $password")

        btnResetPage.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                reset()
                Log.d("MainActivity","reset button clicked")
            }
        })
    }
    fun reset(){

        val resetIntent = Intent(this,resetPasswordActivity::class.java)
        startActivity(resetIntent)

    }
}