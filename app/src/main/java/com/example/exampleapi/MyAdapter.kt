package com.example.exampleapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init
import com.example.exampleapi.databinding.ItemBinding
import com.example.exampleapi.models.MainResponse
import com.example.exampleapi.models.TeamData

class MyAdapter :RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private var list = ArrayList<TeamData>()
    private lateinit var listener : ((String)-> Unit)
    private lateinit var cardListener : ((String ,String)-> Unit)



    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var binding =  ItemBinding.bind(view)

        init{
            itemView.setOnClickListener {
                listener?.invoke(list[adapterPosition].id)
            }
        }
        init {
            binding.cardView.setOnClickListener {
                cardListener?.invoke(list[adapterPosition].id , list[adapterPosition].name)
            }
        }
        fun bind(){
            binding.textName.text = list[adapterPosition].name
            Glide.with(binding.imageFilterView)
                .load(list[adapterPosition].logos.light)
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.imageFilterView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item , parent , false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun submitList(newList : ArrayList<TeamData>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
    fun initClickListener(l : ((String)-> Unit)){
        listener = l
    }

    fun initCArdClickListener(l : ((String , String)-> Unit)){
        cardListener = l
    }
}