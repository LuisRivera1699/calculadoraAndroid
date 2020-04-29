package com.example.holaandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

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
            val username = eteUsername!!.text
            val password = etePassword!!.text

            if (username.toString() == "android" && password.toString() == "password"){
                Toast.makeText(this, "Login correcto", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Login incorrecto", Toast.LENGTH_SHORT).show()
            }
        }
    }



}
