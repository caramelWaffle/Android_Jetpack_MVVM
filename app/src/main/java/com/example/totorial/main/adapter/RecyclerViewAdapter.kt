package com.example.totorial.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.totorial.databinding.RecyclerviewItemBinding
import kotlinx.android.synthetic.main.recyclerview_item.view.*


class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecyclerviewItemBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return 100
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(position)
    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(position: Int){
            view.tv_name.text = "User $position"
        }
    }
}