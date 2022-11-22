package com.example.supermercadoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCliente = findViewById<Button>(R.id.btnCliente)

        btnCliente.setOnClickListener() {
            val intent = Intent(this, ActivityCliente::class.java)
            startActivity(intent)
        }


    }



}