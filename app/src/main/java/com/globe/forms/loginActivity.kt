package com.globe.forms

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class loginActivity : AppCompatActivity(){
    private lateinit var tvAppName: TextView
    private lateinit var imgAppLogo: ImageView
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tvAppName = findViewById(R.id.tvAppName)
        imgAppLogo = findViewById(R.id.imgAppLogo)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        loginListener()
        btnLogin.setOnClickListener(object: OnClickListener{
            override fun onClick(v: View?) {
                Log.d("LoginActivity","button clicked")
                loginListener()
            }
        })

    }

    fun loginListener(){

        val isValidPassword = validatePassword()

        if (!isValidPassword){
            Toast.makeText(this,"password should be greater than 6",Toast.LENGTH_SHORT).show()
            return
        }

        val email = etEmail.text.toString()
        val password = etPassword.text.toString()
        btnLogin.setOnClickListener(object: OnClickListener{
            override fun onClick(v: View?) {
                Log.d("LoginActivity","email: $email password:$password")
            }
        })
        val mainIntent = Intent(this,MainActivity::class.java)
        mainIntent.putExtra("email", email)
        mainIntent.putExtra("password",password)
        startActivity(mainIntent)
        finish()

    }

    private fun validatePassword(): Boolean {
        val password = etPassword.text.toString()
        return password.length > 6
    }

}
