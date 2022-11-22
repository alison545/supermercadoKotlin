package com.example.supermercadoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class ActivityCliente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)

        val presioname =findViewById<Button>(R.id.btnIngresar)
        presioname.setOnClickListener(){

            verificar()
        }

    }

    fun verificar() {

        val nombre = findViewById<EditText>(R.id.editTextNombre)
        val apellido = findViewById<EditText>(R.id.editTextApellido)
        val dni = findViewById<EditText>(R.id.editTextDni)

        val nombreRegistro = nombre.text.toString()
        val apellidoRegistro= apellido.text.toString()
        val dniRegistro = dni.text.toString().toInt()

        if (nombreRegistro.equals("")) {
            Toast.makeText(this, "Nombre vacio", Toast.LENGTH_SHORT).show()
        }else {
            if (apellidoRegistro.equals("")) {
                Toast.makeText(this, "Apellido vacio", Toast.LENGTH_SHORT).show()
            } else if (dniRegistro.equals("")) {
                Toast.makeText(this, "Dni vacio", Toast.LENGTH_SHORT).show()
            } else
                {

                    Toast.makeText(this, "Ingreso exitoso",Toast.LENGTH_SHORT).show()
                    var cliente = Cliente(1)

                    cliente.nombre=nombreRegistro
                    cliente.apellido=apellidoRegistro
                    cliente.dni=dniRegistro

                    val intent = Intent(this, ActivityCompra::class.java)
                    intent.putExtra("Nombre",nombreRegistro) //el primero es una llave, el putExtra agrega datos extendidos
                    intent.putExtra("Apellido",apellidoRegistro) //el primero es una llave, el putExtra agrega datos extendidos
                    intent.putExtra("Dni",dniRegistro) //el primero es una llave, el putExtra agrega datos extendidos
                    startActivity(intent)

                }


        }

    }

}