package com.example.afinal

class Paciente
    (var id: Int,var nombre:String,
               var edad:String, var tipoSangre: String,
               var cedula: String, var doctor: String,
var latitud: String, var longitud: String,var url:String, var urlImagen: String) {


    override fun toString(): String {
        return "id: ${id}, nombre:${nombre}, edad: ${edad}, tipo de Sangre:${tipoSangre}, doctor:${doctor}"
    }


}