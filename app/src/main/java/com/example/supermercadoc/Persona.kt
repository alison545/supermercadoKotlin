package com.example.supermercadoc

abstract class Persona {

    var nombre : String=""
    var apellido: String=""
    var edad: Int=0
    var dni: Int=0

    constructor(nombre: String, edad: Int, apellido: String, dni: Int){
        this.nombre= nombre
        this.edad= edad
        this.apellido=apellido
        this.dni=dni
    }

}