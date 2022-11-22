package com.example.supermercadoc

import android.os.Parcel
import android.os.Parcelable
//El compilador solo usa las propiedades que se encuentra en el constructor principal para autogenerar los métodos de utilidad.

class Cliente (): Persona("",0, "",0) {

    var idCliente: Int=0

    constructor(idCliente:Int):this() {
        this.idCliente=idCliente
    }



}