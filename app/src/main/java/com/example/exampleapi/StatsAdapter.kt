package com.example.exampleapi

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.exampleapi.databinding.ItemFourBinding
import com.example.exampleapi.databinding.ItemThreeBinding
import com.example.exampleapi.models.Standings
import com.example.exampleapi.models.Stats

class StatsAdapter : RecyclerView.Adapter<StatsAdapter.ViewHolder>() {

    var list = ArrayList<Stats>()

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var binding = ItemFourBinding.bind(view)

        fun bind(){
            binding.apply {
                name.text = list[adapterPosition].name
                value.text = list[adapterPosition].value
            }

        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatsAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_four , parent , false))
    }

    override fun onBindViewHolder(holder: StatsAdapter.ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun submitList(newList: ArrayList<Stats>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }



}