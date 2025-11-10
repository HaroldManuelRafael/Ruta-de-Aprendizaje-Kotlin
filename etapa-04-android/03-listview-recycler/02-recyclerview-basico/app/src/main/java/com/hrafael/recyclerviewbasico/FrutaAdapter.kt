package com.hrafael.recyclerviewbasico

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FrutaAdapter(private val listaFrutas: List<Fruta>) :
    RecyclerView.Adapter<FrutaAdapter.FrutaViewHolder>() {

    class FrutaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        val imgFruta: ImageView = itemView.findViewById(R.id.imgFruta)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FrutaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fruta, parent, false)
        return FrutaViewHolder(view)
    }

    override fun onBindViewHolder(holder: FrutaViewHolder, position: Int) {
        val fruta = listaFrutas[position]
        holder.tvNombre.text = fruta.nombre
        holder.imgFruta.setImageResource(fruta.imagenResId)
    }

    override fun getItemCount(): Int = listaFrutas.size
}