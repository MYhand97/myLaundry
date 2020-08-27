package com.myhand.mylaundry.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.myhand.mylaundry.R
import com.myhand.mylaundry.models.DataModels

class MyAdapter(var context: Context, var list: List<DataModels>?) : RecyclerView.Adapter<MyAdapter.ItemHolder>(){

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var id: TextView = itemView.findViewById<TextView>(R.id.tv_id)
        var nama: TextView = itemView.findViewById<TextView>(R.id.tv_nama)
        var alamat: TextView = itemView.findViewById<TextView>(R.id.tv_alamat)
        var notelp: TextView = itemView.findViewById<TextView>(R.id.tv_notelp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.rows, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var dataModels: DataModels = list!!.get(position)

        holder.id.text = dataModels.id.toString()
        holder.nama.text = dataModels.nama
        holder.alamat.text = dataModels.alamat
        holder.notelp.text = dataModels.notelp

    }

    override fun getItemCount(): Int {
        return list!!.size
    }
}
