package com.example.exampleapi.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exampleapi.R
import com.example.exampleapi.StatsAdapter
import com.example.exampleapi.databinding.FragmentInfoBinding
import com.example.exampleapi.models.Stats

class InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater.inflate(R.layout.fragment_info, container, false)
        val binding = FragmentInfoBinding.bind(view)
        val adapter = StatsAdapter()
        binding.stangsRV.adapter = adapter
        var arr = arguments?.getSerializable("data") as ArrayList<Stats>
        adapter.submitList(arr)
        binding.title.text = arguments?.getString("name")

        return view
    }

}