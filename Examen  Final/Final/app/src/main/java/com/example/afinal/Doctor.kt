package com.example.afinal

 class Doctor (
    var id: Int,
    var createdAt: Long,
    var updatedAt: Long,
    var nombre:String,
    var edad:String,
    var tipoSangre:String,
    var peso:String,

    var paciente:String) {

     override fun toString(): String {
         return "Nombre: ${nombre}, edad:${edad}"
     }
 }