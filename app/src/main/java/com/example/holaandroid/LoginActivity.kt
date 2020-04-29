package com.example.holaandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    var butLogin : Button? = null
    var eteUsername : EditText? = null
    var etePassword : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        butLogin = findViewById<Button>(R.id.butLogin)
        eteUsername = findViewById<EditText>(R.id.eteUsername)
        etePassword = findViewById<EditText>(R.id.etePassword)

        butLogin!!.setOnClickListener{ view : View ->
            Log.i("LoginActivity", "Se hizo click")
        }
    }



}
