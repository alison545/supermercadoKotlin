package com.example.supermercadoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class ActivityCompra : AppCompatActivity() {
    var productos= arrayListOf<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compra)

        val extras= intent.extras //obtengo los datos extra

        var nombre = extras?.getString("Nombre")
        var apellido = extras?.getString("Apellido")
        var dni = extras?.getString("Dni")

        val txtNombre: TextView = findViewById<TextView>(R.id.txtNombre)
        val txtApellido: TextView = findViewById<TextView>(R.id.txtApellido)

        txtNombre.text=nombre
        txtApellido.text=apellido


        var btnPagar = findViewById<Button>(R.id.btnComprar)
        btnPagar.setOnClickListener() {

            var intent = Intent (this, ActivityPagar::class.java)

            for (i in productos.indices) {

                intent.putExtra("producto${(i+1).toString()}",productos[i])
            }

            intent.putExtra("cantidad", (productos.size).toString())

            startActivity(intent)

        }


        var btnAgregar =findViewById<Button>(R.id.btnAgregar)
        btnAgregar.setOnClickListener()  {

            var p: Producto = agregarProductos()
            if(p!=null){
                productos.add(p)
                //Toast.makeText(this, "${productos[productos.size-1].nombreProd} ${productos.size} ", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "Producto ${productos[productos.size-1].nombreProd} agregado", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this, "Ingrese un producto", Toast.LENGTH_SHORT).show()
            }


        }

    }
    fun agregarProductos() : Producto {

        var nombre = findViewById<EditText>(R.id.editTextNombreP)
        var tipo = findViewById<EditText>(R.id.editTextTipo)
        var precio = findViewById<EditText>(R.id.editTextPrecio)

        val nombreP = nombre.text.toString()
        val tipoP= tipo.text.toString()
        val precioP = precio.text.toString().toDouble()

        var productoVerificado: Producto= Producto()

        if (nombreP.equals("")) {
            Toast.makeText(this, "Nombre vacio", Toast.LENGTH_SHORT).show()
        }
        else
        {
            if (tipoP.equals("")) {
                Toast.makeText(this, "Tipo vacio", Toast.LENGTH_SHORT).show()
            } else if (precioP.equals("")) {
                Toast.makeText(this, "Precio vacio", Toast.LENGTH_SHORT).show()
            } else
            {
                var producto = Producto(nombreP,tipoP,precioP)
                productoVerificado= producto

            }
        }
        nombre.setText("")
        tipo.setText("")
        precio.setText("")
        return productoVerificado
    }
}