package com.example.androidintroduccion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_ciclo_vida.*

class CicloVida : AppCompatActivity() {

    var numeroActual=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciclo_vida)
        Log.i("Activity","OnCreate")

        btn_anadir
            .setOnClickListener {
                sumarUnValor() }
    }

    fun sumarUnValor(){
        numeroActual= numeroActual+1

        tv_numero.text=numeroActual.toString()
    }

    override fun onStart() {
        super.onStart()
        Log.i("activity", "OnStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("activity", "OnRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("activity", "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("activity", "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("activity", "OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("activity", "OnDestroy")
    }

}