package com.example.exampleapi

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.exampleapi.databinding.ItemThreeBinding
import com.example.exampleapi.models.Standings
import com.example.exampleapi.models.Team

class TeamsAdapter : RecyclerView.Adapter<TeamsAdapter.ViewHolder>() {
    var list = ArrayList<Standings>()
    lateinit var listener : ((Standings) -> Unit)

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var binding = ItemThreeBinding.bind(view)
        init {
            itemView.setOnClickListener {
                listener?.invoke(list[adapterPosition])
            }
        }

        fun bind(){
            binding.apply {
                textName.text = list[adapterPosition].team.name
                Glide.with(itemView.context)
                    .load(list[adapterPosition].team.logos[0].image)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(imageFilterView)
                Log.d("AAA2" ,list[adapterPosition].team.logos[0].toString())
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsAdapter.ViewHolder {
       return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_three , parent , false))
    }

    override fun onBindViewHolder(holder: TeamsAdapter.ViewHolder, position: Int) {
       holder.bind()
    }

    override fun getItemCount(): Int {
       return list.size
    }

    fun submitList(newList: ArrayList<Standings>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    fun initListener(l : ((Standings) -> Unit)){
        listener = l
    }



}