package com.example.afinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_agregar_doctor.*

class AgregarDoctorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_doctor)
        val posicion= intent.getIntExtra("index",-1)

        if(posicion>-1){
            //Me enviaron para modificar
            tv_agregar_modificar_c.text="Modificar "
            btn_agregar_modificar.setText("MODIFICAR")
            var doctor: Doctor? = BddService.obtenerDoctor(posicion)
            if (doctor != null) {

                et_nombre.setText(doctor.nombre)
                et_color_entrenador.setText(doctor.edad)
                et_nivel.setText(doctor.tipoSangre)
                et_entre_activo.setText(doctor .peso)
                et_pokemones.setText(doctor.paciente)

            }
            btn_agregar_modificar.setOnClickListener {
                BddService.modificarDoctor(posicion,
                    et_nombre.text.toString(),
                    et_color_entrenador.text.toString(),
                   et_nivel.text.toString(),
                   et_entre_activo.text.toString(),
                    et_pokemones.text.toString()
                )
                Toast.makeText(applicationContext,"Doctor Modificada con Exito",Toast.LENGTH_SHORT).show()
                ir_doctor(posicion)
            }

        }else{
            tv_agregar_modificar_c.text="Agregar Doctor"
            btn_agregar_modificar.setText("AGREGAR")
            //Me enviaron para agregar
            btn_agregar_modificar.setOnClickListener {
                BddService.agregarDoctor(
                    et_nombre.text.toString(),
                    et_color_entrenador.text.toString(),
                    et_nivel.text.toString(),
                    et_entre_activo.text.toString(),
                    et_pokemones.text.toString()
                )
                Toast.makeText(applicationContext,"doctor Agregado con Exito",Toast.LENGTH_SHORT).show()
                ir_lista_doctores()
            }
        }
        btn_agregar_a_lista.setOnClickListener {
            this.startActivity(Intent(this,ListaDoctoresActivity::class.java))
        }
        btn_agregar_a_main.setOnClickListener {
            this.startActivity(Intent(this,MainActivity::class.java))
        }
    }
    fun ir_doctor(posicion:Int){
        val intentExplicito= Intent(this, DoctorActivity::class.java)
        intentExplicito.putExtra("index",posicion)
        this.startActivity(intentExplicito)
    }
    fun ir_lista_doctores(){
        val intentExplicito= Intent(this, ListaDoctoresActivity::class.java)
        this.startActivity(intentExplicito)
    }

}