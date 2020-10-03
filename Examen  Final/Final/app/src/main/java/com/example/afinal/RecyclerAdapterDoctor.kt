package com.example.afinal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class RecyclerAdapterDoctor(
    private val listaEntrenador: List<Doctor>,
    private val contexto: RecyclerViewActivity,
    private val recyclerView: androidx.recyclerview.widget.RecyclerView
): androidx.recyclerview
.widget.RecyclerView.Adapter<RecyclerAdapterDoctor.MyViewHolder>() {

    inner class MyViewHolder(view: View):
    androidx.recyclerview.widget.RecyclerView.ViewHolder(view){
        var nombreEntrenadorTextView : TextView
        var colorEntrenadorTextView : TextView

        init {
            nombreEntrenadorTextView = view.findViewById(R.id.tv_nombre)
            colorEntrenadorTextView = view.findViewById(R.id.tv_color)

        }

    }
    //numero de items
    override fun getItemCount(): Int {
        return listaEntrenador.size   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapterDoctor.MyViewHolder {
        //interfaz que voy a usar
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.adaptador_doctor //recursos   Adapatador_persona.xml
                , parent, false)
        return MyViewHolder(itemView)
    }

    //funcion que se ejecuta con cada uno de los items

    override fun onBindViewHolder(
        holder: MyViewHolder //clase implemetada 8arriba)
        , position: Int) { //posicion

        val doctor = listaEntrenador[position]
        holder.nombreEntrenadorTextView.text = doctor.nombre
        holder.colorEntrenadorTextView.text = doctor.edad


    }


}