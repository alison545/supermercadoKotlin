package com.example.supermercadoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class ActivityPagar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagar)

        var textView = findViewById<TextView>(R.id.txtP)
        var monto = findViewById<EditText>(R.id.editTextMonto)
        val btnCobrar=findViewById<Button>(R.id.btnCobrar)

        var c = intent.getStringExtra("cantidad")

        var cantidad=c?.toInt()

        var text:String=""
        var total:Double=0.0

        for (i in 1..cantidad!!) {

            var p1: Producto? = intent.getParcelableExtra<Producto>("producto${i}")
            text += "${p1!!.nombreProd.toUpperCase()} ${p1!!.tipo} $${p1.precio}  \n"
            total+=p1.precio
        }

        textView.text = text + "\n TOTAL: $ ${total}"

        btnCobrar.setOnClickListener() {

            val montoIngresado = monto.text.toString().toDouble()

            var txtVuelto=findViewById<TextView>(R.id.txtVuelto)
            var vueltoFinal = cobrar(montoIngresado,total)
            txtVuelto.text = vueltoFinal.toString()
            monto.setText("")
        }

    }

    fun cobrar(monto : Double, total:Double) : Double{
        var vuelto:Double=0.0

        if(monto.equals("")){
            Toast.makeText(this, "Ingrese un monto", Toast.LENGTH_SHORT).show()
        }else {
            if(monto<total){
                Toast.makeText(this, "Monto invalido", Toast.LENGTH_SHORT).show()
            }else {
                vuelto = monto-total
                return vuelto
            }

        }
        return vuelto
    }

}