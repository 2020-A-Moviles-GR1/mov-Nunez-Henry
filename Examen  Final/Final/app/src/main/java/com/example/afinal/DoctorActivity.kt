package com.example.afinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_doctor.*

class DoctorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor)
        val posicion= intent.getIntExtra("index",-1)

        if(posicion>-1){
            var doctor: Doctor? = BddService.obtenerDoctor(posicion)
            Log.i("ID-http","${posicion}")
            if (doctor != null) {
                tv_nombre.text=doctor.nombre
                tv_color.text=doctor.edad;
                tv_nivel.text= doctor.tipoSangre;
                tv_activo_entre.text=doctor.peso;
                tv_pokemones.text=doctor.paciente
            };

            btn_eliminar.setOnClickListener {
               BddService.eliminarDoctor(doctor!!.id)
                Toast.makeText(applicationContext,"Entrenador Eliminado", Toast.LENGTH_SHORT).show()
                ir_lista_entrenadores()
            }
            btn_modificar.setOnClickListener {
                var pokemones: Doctor? = BddService.obtenerDoctor(posicion)

                ir_agregar_entrenador(posicion);
            }
            btn_pokemones.setOnClickListener {
                ir_pokemon_entrenador(posicion)
            }

        }else{
            ir_lista_entrenadores()
        }
       // btn_cancion_a_lista.setOnClickListener {
           // ir_lista_entrenadores()
       // }
        btn_entre_a_main.setOnClickListener {
            this.startActivity(Intent(this,MainActivity::class.java))
        }


    }
    fun ir_lista_entrenadores(){
        val intentExplicito= Intent(this, ListaDoctoresActivity::class.java)
        this.startActivity(intentExplicito)
    }
    fun ir_agregar_entrenador(posicion:Int){
        val intentExplicito= Intent(this, AgregarDoctorActivity::class.java)
        intentExplicito.putExtra("index",posicion)
        this.startActivity(intentExplicito)
    }
    fun ir_pokemon_entrenador(posicion:Int){
        val intentExplicito= Intent(this, ListaPacientes::class.java)
        intentExplicito.putExtra("index",posicion   )
        this.startActivity(intentExplicito)
    }
}