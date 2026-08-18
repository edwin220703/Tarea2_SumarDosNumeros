package com.example.apptest

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var edtnum1 : EditText
    lateinit var edtnum2: EditText
    lateinit var btnSum : Button
    lateinit var txtResultado : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        edtnum1 = findViewById(R.id.edtnum1)
        edtnum2 = findViewById(R.id.edtnum2)
        btnSum = findViewById(R.id.btnSum)
        txtResultado = findViewById(R.id.txtResultado)

        btnSum.setOnClickListener {
            var num1 : Double? = edtnum1.text.toString().toDoubleOrNull()
            var num2 : Double? = edtnum2.text.toString().toDoubleOrNull()

            if(num1 == null){
                num1 = 0.0
            }

            if(num2 == null){
                num2 = 0.0
            }

            txtResultado.setText("Resultado: " + Sum(num1,num2))
        }

    }

    fun Sum(numero1: Double, numero2: Double) : Double
    {
        return numero1 + numero2
    }
}