package com.example.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpPost
import kotlinx.android.synthetic.main.activity_http.*
import com.github.kittinunf.result.Result

class HttpActivity : AppCompatActivity() {
    val url = "http://192.168.1.23:1337"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http)

        btn_obtner.setOnClickListener {
            obtenerUsuarios()
        }

        btn_crear.setOnClickListener {
            crearUsuario()
        }
    }

    fun crearUsuario() {
        val urlUsuario = "$url/usuario"
        /*
         "createdAt": 1597885890003,
    "updatedAt": 1597885890003,
    "id": 1,
    "cedula": "1751106888",
    "nombre": "Henry",
    "correo": "henry.nunez@epn.edu.ec",
    "estadoCivil": "soltero",
    "password": "22sds22"
         */

        val usuario: List<Pair<String, String>> = listOf(
            "cedula" to "1751106888",
            "nombre" to "Jona",
            "correo" to "hejonusa@gmail.com",
            "password" to "123sds123"
        )

        urlUsuario
            .httpPost(
                usuario
            )
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val error = result.getException()
                        Log.i("http-klaxon", "Error $error")
                    }
                    is Result.Success -> {
                        val usuario = result.get()
                        Log.i("http-klaxon", "Exito crear $usuario")

                    }
                }
            }
    }

    fun obtenerUsuarios() {//Problema es que estamos trabajando con usuario entero o http

        val pokemonString = """
        [
          {
            "createdAt": 1598531451966,
            "updatedAt": 1598531451966,
            "id": 1,
            "nombre": "pikachu",
            "usuario": {
              "createdAt": 1599448691629,
              "updatedAt": 1599448691629,
              "id": 1,
              "cedula": "1751106888",
                "nombre": "Henry",
                "correo": "henry.nunez@epn.edu.ec",
                "estadoCivil": "soltero",
                "password": "22sds22"
            }
          },
          {
            "createdAt": 1598531451966,
            "updatedAt": 1598531451966,
            "id": 1,
            "nombre": "pikachu",
            "usuario": 2
          }
        ]
        """.trimIndent()


        val respuesta = Klaxon()  //clase converter
            .converter(Pokemon.myConverter)
            .parseArray<Pokemon>(pokemonString)

        val existeRespuesta = respuesta?.size

        if (existeRespuesta != null) {
            if (existeRespuesta > 0) {

                respuesta.forEach { pokemon: Pokemon ->
                    when (pokemon.usuario) {
                        is Int -> Log.i("http-klaxon", "${pokemon.usuario}")
                        is UsuarioHttp -> {
                            val usuario = pokemon.usuario as UsuarioHttp
                            Log.i("http-klaxon", usuario.nombre)
                        }
                    }
                }


    //            val urlUsuario = "$url/usuario"
    //            urlUsuario
    //                .httpGet()
    //                .responseString { request, response, result ->
    //                    when (result) {
    //                        is Result.Success -> {
    //                            val data = result.get()
    //                            Log.i("http-klaxon", "Ddatitos: ${data}")
    //                        }
    //                        is Result.Failure -> {
    //                            val ex = result.getException()
    //                            Log.i("http-klaxon", "Error http ${ex.message}")
    //                        }
    //                    }
    //                }
            }
        }
    }
}