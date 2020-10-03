package com.example.afinal

import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result

class BddService {
    companion object{
        val urlPrincipal="http://192.168.1.15:1337"

        var listDoctores= listOf<Doctor>()
        var doctor: Doctor? =null
        var paciente: Paciente? =null

        var listaPacientes= listOf<Paciente>()
        fun buscarPacientes(chord:String): Paciente? {
            var paciente=chord.toLowerCase()

            var pacienteEncontrado=listaPacientes.find{

                    pacientes -> pacientes.nombre.equals(paciente)

            }



            return pacienteEncontrado
        }

        fun getDoctores() {

            val url= "$urlPrincipal/doctor"
            url.httpGet().responseString{
                    request, response, result ->
                when(result){
                    is Result.Success->{
                        val data=result.get()
                        val doctores=Klaxon().parseArray<Doctor>(data)
                        if(doctores!=null){
                            this.listDoctores=doctores
                            doctores.forEach {
                            }

                        }

                    }
                    is Result.Failure->{
                        val ex=result.getException()
                        Log.i("Http Exception","Error  doctores: $ex.message")

                    }
                }
            }.join()
        }
        fun getPaciente(id: Int){
            val url= "$urlPrincipal/paciente/${id}"
            url.httpGet().responseString{
                    request, response, result ->
                when(result){
                    is Result.Success->{
                        val data=result.get()
                        val paciente=Klaxon().parse<Paciente>(data)
                        if(paciente!=null){

                            this.paciente=paciente


                        }

                    }
                    is Result.Failure->{
                        val ex=result.getException()
                        Log.i("Http Exception","Error: $ex.message")

                    }
                }
            }.join()
        }
        fun getPacientes(){
            val url= "$urlPrincipal/paciente"
            url.httpGet().responseString{
                    request, response, result ->
                when(result){
                    is Result.Success->{
                        val data=result.get()
                        Log.i("PRUEBA2","PACIENTE: ${data}")

                        val paciente=Klaxon().parseArray<Paciente>(data)
                        if(paciente!=null){
                            this.listaPacientes=paciente

                            paciente.forEach {
                            }

                        }

                    }
                    is Result.Failure->{
                        val ex=result.getException()
                        Log.i("Http Exception","Error  doctor: $ex.message")

                    }
                }
            }.join()
        }



        fun getDoctor(id:Int) {

            val url= "$urlPrincipal/doctor/${id}"
            url.httpGet().responseString{
                    request, response, result ->
                when(result){
                    is Result.Success->{
                        val data=result.get()
                        Log.i("Http data cancion","Data cancion: $data")
                        val doctor=Klaxon().parse<Doctor>(data)
                        if(doctor!=null){
                            this.doctor=doctor
                            Log.i("Http-Klaxon","Nombre ${doctor.nombre} , peso : ${doctor.peso}")



                        }

                    }
                    is Result.Failure->{
                        val ex=result.getException()
                        Log.i("Http Exception","Error  : $ex.message")

                    }
                }
            }.join()
        }


        fun postPaciente(nombre:String, edad:String, tipoSangre:String, cedula:String, doctorNuevo:String, latitud:String, longitud:String, url:String, urlImagen:String){
            val url= "$urlPrincipal/paciente"
            val parametrosUsuario=listOf(
                "nombre" to nombre,
                "edad" to edad,
                "tipoSangre" to tipoSangre,
                "cedula" to cedula,
                "doctor" to doctorNuevo,
                "latitud" to latitud,
                 "longitud" to longitud,
                 "url" to  url,
                 "urlImagen" to  urlImagen
            )
            url.httpPost(parametrosUsuario).responseString{
                    req,res,result->
                when(result){
                    is Result.Failure->{
                        val error= result.getException()
                    }
                    is Result.Success->{
                        val cancionString=result.get()
                    }
                }
            }.join()

        }


        fun postDoctor(nombre:String, edad:String, tipoSangre:String, peso:String, pacientes:String){
            val url= "$urlPrincipal/doctor"
            val parametrosDoctor=listOf(
                "nombre" to nombre,
                "edad" to edad,
                "tipoSangre" to tipoSangre,
                "peso" to peso,
                "paciente" to pacientes
            )
            url.httpPost(parametrosDoctor).responseString{
                    req,res,result->
                when(result){
                    is Result.Failure->{
                        val error= result.getException()
                    }
                    is Result.Success->{
                        val cancionString=result.get()
                    }
                }
            }.join()

        }
        fun deletePaciente(id:Int){
            val url= "$urlPrincipal/paciente/${id}"

            url.httpDelete().responseString{
                    req,res,result->
                when(result){
                    is Result.Failure->{
                        val error= result.getException()
                    }
                    is Result.Success->{
                        val cancionString=result.get()
                    }
                }
            }.join()
        }
        fun deleteDoctor(id:Int){
            val url= "$urlPrincipal/doctor/${id}"

            url.httpDelete().responseString{
                    req,res,result->
                when(result){
                    is Result.Failure->{
                        val error= result.getException()
                    }
                    is Result.Success->{
                        val cancionString=result.get()
                    }
                }
            }.join()
        }

        fun putDoctor(id:Int, nombre:String, edad:String, tipoSangre:String, peso:String, paciente:String){
            val url= "$urlPrincipal/doctor/${id}"
            val parametrosUsuario=listOf(
                "nombre" to nombre,
                "edad" to edad,
                "tipoSangre" to tipoSangre,
                "peso" to peso,
                "paciente" to paciente
            )
            url.httpPut(parametrosUsuario).responseString{
                    req,res,result->
                when(result){
                    is Result.Failure->{
                        val error= result.getException()
                    }
                    is Result.Success->{
                        val doctorString=result.get()
                        Log.i("Http-klaxon","Modificado ${doctorString}")
                    }
                }
            }.join()
        }

        fun putPaciente(id:Int, nombre:String, edad:String, tipoSangre:String, cedula:String, doctor:String, latitud: String, longitud: String, urlnueva: String, urlImagen: String){

            val url= "$urlPrincipal/paciente/${id}"

            val parametrosUsuario=listOf(
                "id" to id,
                "nombre" to nombre,
                "edad" to edad,

                "tipoSangre" to tipoSangre,
                "cedula" to cedula,
                "doctor" to doctor,
                "latitud" to latitud,
                "longitud" to longitud,
                "url" to urlnueva,
                "urlImagen" to urlImagen


            )
            url.httpPut(parametrosUsuario).responseString{
                    req,res,result->
                when(result){
                    is Result.Failure->{
                        val error= result.getException()
                    }
                    is Result.Success->{
                    }
                }
            }.join()
        }

        fun agregarDoctor(nombre:String, color:String, nivel:String, activo:String, acordes:String){
            postDoctor(nombre,color,nivel,activo,acordes)
            getDoctores()
        }
        fun eliminarDoctor(id:Int){
            deleteDoctor(id)
            getDoctores()


        }

        fun elimarPaciente(id:Int){
            deletePaciente(id)
            getPacientes()


        }

        fun modificarDoctor(id:Int, nombre:String, color:String, nivel:String, activo:String, acordes:String){
            putDoctor(id,nombre,color,nivel,activo,acordes)
            getDoctor(id)
        }
        fun obtenerDoctor(posicion: Int): Doctor? {
            getDoctor(posicion)
            return doctor
        }

        fun obtenerPaciente(posicion: Int): Paciente? {
            getPaciente(posicion)
            return paciente
        }




        fun crearPaciente(id:Int, nombre:String, tipo:String, nivel:String, activo: String, doctor:String, latitud:String, longitud:String, url:String, imagen:String){
            postPaciente(nombre,tipo,nivel,activo,doctor, latitud, longitud, url, imagen)
            getPacientes()
        }

        fun modificarPaciente(id:Int, nombre:String, nivel:String, tipo:String, activo: String, doctor:String, latitud: String, longitud: String, url:String, imagen:String){
            putPaciente(id,nombre,nivel,tipo,activo,doctor,latitud,longitud,url,imagen)
           getPacientes()
        }

    }
}