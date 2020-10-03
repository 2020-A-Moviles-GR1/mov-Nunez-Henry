package com.example.afinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_doctores.*

class ListaDoctoresActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_doctores)


        val listaDoctores= BddService.listDoctores
        Log.i("Lista-Http","${listaDoctores}")



        val adaptador= ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            listaDoctores)

        lv_doctores.adapter=adaptador

        lv_doctores.onItemClickListener= AdapterView.OnItemClickListener{
                parent,view,position,id ->
            Log.i("list-view","Posicion ${listaDoctores[position]}")
            irDoctor(listaDoctores[position].id);
        }
        btn_lista_a_main.setOnClickListener {
            this.startActivity(Intent(this,MainActivity::class.java))
        }

        btn_crear_doctor.setOnClickListener {
            this.startActivity(Intent(this,AgregarDoctorActivity::class.java))
        }


    }
    init {
        BddService.getDoctores()
    }
    fun irDoctor(posicion:Int){
        val intentExplicito= Intent(this, DoctorActivity::class.java)
        intentExplicito.putExtra("index",posicion)
        this.startActivity(intentExplicito)
    }




}