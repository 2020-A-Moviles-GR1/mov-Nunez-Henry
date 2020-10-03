package com.example.afinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_paciente.*
import android.content.Intent
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast

class PacienteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paciente)
        BddService.getPacientes()
        val posicion= intent.getIntExtra("index",-1)

        if(posicion>-1){
            var doctor : Doctor? = BddService.obtenerDoctor(posicion)
            tv_cancion_y_autor.setText("Doctor: ${doctor?.nombre} -peso: ${doctor?.peso}")
            val chords=doctor!!.paciente.split(",").toTypedArray()

            val adaptador= ArrayAdapter(this,android.R.layout.simple_list_item_1,chords)
            lv_acordes.adapter=adaptador

            lv_acordes.onItemClickListener= AdapterView.OnItemClickListener{
                    parent,view,position,id ->
                Log.i("list-view","Posicion paciente ${chords[position]}")
                val paciente_encontrado=BddService.buscarPacientes(chords[position])
                Log.i("list-view","POKEMON ENCONTRADO ${paciente_encontrado}")
                if(paciente_encontrado!=null){
                    Log.i("pokemon-econtrado","$paciente_encontrado")
                    //Modificar Pokemon

                    val intentExplicito= Intent(this, ModificarPacienteActivity::class.java)
                    intentExplicito.putExtra("posicon_entrenador", posicion)
                    intentExplicito.putExtra("posicion_pokemon", position)
                    intentExplicito.putExtra("nombre_pokemon", paciente_encontrado.nombre)
                    intentExplicito.putExtra("tipo_pokemon", paciente_encontrado.edad)
                    intentExplicito.putExtra("nivel_pokemon", paciente_encontrado.tipoSangre)

                    Log.i("list-view","Posicion eviado ${chords[position]}")
                    Log.i("list-view","tipo_pokemon ${paciente_encontrado.cedula}")
                  // Log.i("list-view","nivel_pokemon ${pokemon_encontrado.nivel}")
                    this.startActivity(intentExplicito)


                    // this.startActivity(Intent(this,ModificarPokemonActivity::class.java))

                    //   iv_chord.setImageResource(acorde_encontrado.imagen)

                }else{
                    Toast.makeText(applicationContext,"No se encuentra pokemon", Toast.LENGTH_SHORT).show()
                }
            }

        }else{
            this.startActivity(Intent(this,MainActivity::class.java))
        }


        btn_menu.setOnClickListener {
            this.startActivity(Intent(this,MainActivity::class.java))
        }
        btn_acordes_a_lista.setOnClickListener {
            this.startActivity(Intent(this,ListaDoctoresActivity::class.java))
        }





    }


}