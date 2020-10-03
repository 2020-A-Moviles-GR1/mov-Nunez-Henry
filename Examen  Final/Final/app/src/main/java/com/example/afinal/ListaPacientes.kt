package com.example.afinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_pacientes.*

class ListaPacientes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_pacientes)
        val lista_pacientes = BddService.listaPacientes


        val adaptador = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            lista_pacientes
        )

        lv_lista_pokemones.adapter = adaptador

        lv_lista_pokemones.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->

                //   irEntrenador(lista_pokemones[position].id);
                irModificar(lista_pacientes[position].id)
            }

        btn_ir_entrena.setOnClickListener {
            this.startActivity(Intent(this, MainActivity::class.java))
        }
        btn_atras_paciente.setOnClickListener {
            this.startActivity(Intent(this, MainActivity::class.java))
        }
        btn_a_mapa.setOnClickListener {
            this.startActivity(Intent(this, MapsActivity::class.java))
        }
    }


    init {
        BddService.getPacientes()
    }


    fun irModificar( posicion: Int){
        val intentExplicito= Intent(this, ModificarPacienteActivity::class.java)
       intentExplicito.putExtra("posicion_pokemon",posicion)

        this.startActivity(intentExplicito)
    }

}