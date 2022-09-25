package com.example.exampleapi.screens

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.exampleapi.*
import com.example.exampleapi.databinding.FragmentSeasonsBinding
import com.example.exampleapi.models.MainForSeasons
import com.example.exampleapi.models.MainResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SeasonsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view =  inflater.inflate(R.layout.fragment_seasons, container, false)
        val binding = FragmentSeasonsBinding.bind(view)
        var id = arguments?.getString("id").toString()
        val name = arguments?.getString("Name").toString()
       binding.title.text = name
        var adapter = SeasonAdapter()
        binding.recyclerViewSeason.adapter = adapter

        var api = Network.getRetrofit(requireContext()).create(apiHelper::class.java)

        api.getItemSeasons(id).enqueue(
            object : Callback<MainResponse<MainForSeasons>> {
                override fun onResponse(
                    call: Call<MainResponse<MainForSeasons>>,
                    response: Response<MainResponse<MainForSeasons>>
                ) {
                    if (response.isSuccessful && response.code() == 200 ){
                        binding.progressBar.visibility = View.GONE
                        adapter.submitList(response.body()?.data?.seasons ?: arrayListOf())
                        Log.d("AAA" , "${response.body()}")
                    }

                }

                override fun onFailure(call: Call<MainResponse<MainForSeasons>>, t: Throwable) {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Error on Network", Toast.LENGTH_SHORT).show()
                }

            }
        )


        adapter.initListener {
            var bundle = Bundle()
            bundle.putString("id",id)
            bundle.putString("year" , it)
            findNavController().navigate(R.id.action_seasonsFragment_to_tableFragment , bundle)
        }

        return view
    }

}