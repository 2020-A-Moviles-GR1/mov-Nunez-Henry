package com.example.afinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.afinal.BddService.Companion.paciente
import kotlinx.android.synthetic.main.activity_modificar_paciente.*

class ModificarPacienteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modificar_paciente)
        val posicion_entrenador= intent.getIntExtra("posicon_entrenador", -1)
       var posicion= intent.getIntExtra("posicion_pokemon", -1)
        val nombrellega : String? = intent.getStringExtra("nombre_pokemon")
        val tipollega : String? = intent.getStringExtra("tipo_pokemon")
        val nivelllega : String? = intent.getStringExtra("nivel_pokemon")
        Log.i("Http-klaxonPOKEMON","posicion recibido ${posicion}")
        val Entrenador_dueno=BddService.obtenerDoctor(posicion_entrenador)
        val pokemon_encontrado=BddService.buscarPacientes(nombrellega.toString())

        if(posicion>-1){
            var paciente = BddService.obtenerPaciente(posicion)
            Log.i("ENVIOOOOO","LLEGA: ${paciente}")

            etv_id_pokemon.setText(paciente?.id.toString())
            etv_nombre_poke_mod.setText(paciente?.nombre)
            etv_edad.setText(paciente?.edad)
            et_nivel_pokemon_ed.setText(paciente?.tipoSangre)
            etv_tipoSangre.setText(paciente?.cedula)
            etv_entrenador_due.setText(paciente?.doctor)
            etv_imagen_pokemon.setText(paciente?.urlImagen)
            etv_latitud.setText(paciente?.latitud)
            etv_longitud.setText(paciente?.longitud)
         //   etv_entrenador_due.setText(pokemon?.)

        }


     else{
            Toast.makeText(applicationContext,"No se encuentra pokemon", Toast.LENGTH_SHORT).show()
        }
        btn_modificar_pokemon.setOnClickListener {
            BddService.modificarPaciente(posicion,
                etv_nombre_poke_mod.text.toString(),
                etv_edad.text.toString(),
                et_nivel_pokemon_ed.text.toString(),
                etv_tipoSangre.text.toString(),

              //tv_nombre.text.toString()
                etv_entrenador_due.text.toString(),
                etv_latitud.text.toString(),
                etv_longitud.text.toString(),
                "https://www.epn.edu.ec/",
                etv_imagen_pokemon.text.toString()


            )
            Toast.makeText(applicationContext,"POKEMON Modificada con Exito",Toast.LENGTH_SHORT).show()
            ir_activity_pokemones()
        }

        btn_crear_pokemon.setOnClickListener {
            BddService.crearPaciente(posicion,
                etv_nombre_poke_mod.text.toString(),
                etv_edad.text.toString(),
                et_nivel_pokemon_ed.text.toString(),
                etv_tipoSangre.text.toString(),

                //tv_nombre.text.toString()
                etv_entrenador_due.text.toString(),
                etv_latitud.text.toString(),
                etv_longitud.text.toString(),
                //quemar url
                "https://www.epn.edu.ec/",
                etv_nombre_poke_mod.text.toString()
            )
            Toast.makeText(applicationContext,"POKEMON Modificada con Exito",Toast.LENGTH_SHORT).show()
            ir_activity_pokemones()
        }


        btn_eliminar_pokemon.setOnClickListener {
          BddService.deletePaciente(posicion)
            val intentExplicito= Intent(this, ListaPacientes::class.java)
            this.startActivity(intentExplicito)

            Toast.makeText(applicationContext,"POKEMON eliminado con Exito",Toast.LENGTH_SHORT).show()
        }




        btn_mapa.setOnClickListener {
          //  irSoloMapa()
            irMapa(paciente!!.nombre,"${paciente!!.edad}")


         //   irSoloMapa(pokemon!!.latitud, etv_longitud.text.toString())
            Log.i("MAPA", "ENVIO: ${paciente!!.latitud}, ${ etv_longitud.text.toString()}")
        }
    }
    fun ir_list_pokemones(){
        val intentExplicito= Intent(this, ListaPacientes::class.java)
    //    intentExplicito.putExtra("index",posicion)
        this.startActivity(intentExplicito)
    }
    fun ir_activity_pokemones(){
        val intentExplicito= Intent(this, PacienteActivity::class.java)
        //    intentExplicito.putExtra("index",posicion)
        this.startActivity(intentExplicito)
    }

    fun irSoloMapa(
        latitud:String, longitud:String
    ){
        val intent = Intent(this, MapsActivity::class.java)
        intent.putExtra("latitud",latitud)
        intent.putExtra("longitud",longitud)
        this.startActivity(intent)

        this.startActivity(intent)
    }
    fun irMapa(nombre:String,tipo:String){
        val intent = Intent(this, MapsActivity::class.java)

        this.startActivity(intent)
    }
}