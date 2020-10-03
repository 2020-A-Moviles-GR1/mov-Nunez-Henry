package com.example.afinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_paciente.setOnClickListener {
            this.startActivity(Intent(this, ListaPacientes::class.java))
        }
        btn_hospital.setOnClickListener {
            AbrirListaEntrenadores()
        }



    }

    fun AbrirListaEntrenadores(){

        val intentExplicito = Intent(
            this,
            ListaDoctoresActivity::class.java
        )
        startActivity(intentExplicito)
    }



    fun abrirRecycler() {
        val intentExplicito = Intent(
            this,
            RecyclerViewActivity::class.java
        )
        startActivity(intentExplicito)
    }



}