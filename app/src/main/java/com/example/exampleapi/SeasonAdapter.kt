package com.example.exampleapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleapi.databinding.ItemTwoBinding
import com.example.exampleapi.models.SeasonData

class SeasonAdapter : RecyclerView.Adapter<SeasonAdapter.ViewHolder>(){
    var list = ArrayList<SeasonData>()
    lateinit var listener : ((String) -> Unit)



    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var binding = ItemTwoBinding.bind(view)
        init {
            itemView.setOnClickListener {
                listener?.invoke(list[adapterPosition].year.toString())
            }
        }
        fun bind(){
            binding.yearsTV.text = list[adapterPosition].displayName

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_two , parent ,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun submitList(newList : ArrayList<SeasonData>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    fun initListener(l:(String) -> Unit){
        listener = l
    }





}