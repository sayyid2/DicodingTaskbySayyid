package com.example.dicodingtaskbysayyid

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListPokeAdapter(private val listPoke: ArrayList<Pokemon>) :RecyclerView.Adapter<ListPokeAdapter.ListHolder>() {
    private lateinit var onItemClickCallback:OnItemClickCallback

    fun setOnItemClickCallback (onItemClickCallback:OnItemClickCallback){
        this.onItemClickCallback=onItemClickCallback
    }

    class ListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pict: ImageView = itemView.findViewById(R.id.item_picture)
        val tvPoke: TextView = itemView.findViewById(R.id.item_name)
        val tvDesc: TextView = itemView.findViewById(R.id.item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_poke, parent, false)
        return ListHolder(view)
    }

    override fun getItemCount(): Int = listPoke.size

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        val (name, desc, pic) = listPoke[position]
        Glide.with(holder.itemView.context)
            .load(pic)
            .circleCrop()
            .into(holder.pict)
        holder.tvPoke.text = name
        holder.tvDesc.text = desc

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listPoke[holder.adapterPosition])}
    }

    interface OnItemClickCallback{
        fun onItemClicked(data:Pokemon)
    }
}