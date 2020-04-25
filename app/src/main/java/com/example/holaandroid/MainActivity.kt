package com.example.holaandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.lang.NullPointerException

//Componente de android
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // <-- Donde se relaciona una definicion de pantalla con un activity
    }

    val addition : (Int, Int) -> Int = { a, b -> a + b}
    val substraction : (Int, Int) -> Int = { a, b -> a - b}
    val division : (Int, Int) -> Int = { a, b -> a / b}
    val multiplication : (Int, Int) -> Int = { a, b -> a * b}

    fun opperate(num1 : Int, num2 : Int, opperator : String) : Int{

        return if (opperator == "+"){
            addition(num1, num2)
        }else if(opperator == "-"){
            substraction(num1, num2)
        }else if(opperator == "*"){
            multiplication(num1, num2)
        }else{
            division(num1, num2)
        }
    }

    var firstNumber : String? = null
    var lastNumber : String? = null
    var currentOperator : String? = null

    fun doOperation(view: View){
        val eteNum : EditText = findViewById(R.id.eteNumeros)

        var result : Int? = null

        val msg : String = "Syntax Error: Press C and try again."

        try{
            var fnum : Int? = this.firstNumber!!.toInt()
            var lnum : Int? = this.lastNumber!!.toInt()
            var cop : String? = this.currentOperator

            result = this.opperate(fnum!!, lnum!!, cop!!)
            Log.i("HolaAndroid", result.toString())
            eteNum.setText(result.toString())
            this.firstNumber = result.toString()
            this.lastNumber = null
            this.currentOperator = null
        }catch (e: Exception){
            eteNum.setText(msg)
            this.currentOperator = null
            this.firstNumber = null
            this.lastNumber = null
        }
    }

    fun setOperator(view: View){
        val buttonOp : Button = view as Button
        val eteNum : EditText = findViewById(R.id.eteNumeros)

        if (this.currentOperator == null){
            eteNum.text.append(buttonOp.text)
            this.currentOperator = buttonOp.text.toString()
        }else {
            this.doOperation(view)
            eteNum.text.append(buttonOp.text)
            this.currentOperator = buttonOp.text.toString()
        }
    }

    fun butOnClick(view: View) {
        val but : Button = view as Button
        val eteNum : EditText = findViewById(R.id.eteNumeros)

        if (eteNum.text.toString() == "0"){
            eteNum.setText(but.text)
        }else {
            eteNum.text.append(but.text)
        }

        if (this.firstNumber == null){
            this.firstNumber = but.text.toString()
        }else if(this.currentOperator == null){
            this.firstNumber = this.firstNumber + but.text
        }else if(this.lastNumber == null){
            this.lastNumber = but.text.toString()
        }else{
            this.lastNumber = this.lastNumber + but.text
        }


        Log.i("HolaAndroid", "Se hizo click en el boton "+but.text)
    }

    fun resetAll(view: View){
        this.firstNumber = null
        this.lastNumber = null
        this.currentOperator = null
        var eteNum : EditText = findViewById(R.id.eteNumeros)

        eteNum.setText("0")

    }
}
