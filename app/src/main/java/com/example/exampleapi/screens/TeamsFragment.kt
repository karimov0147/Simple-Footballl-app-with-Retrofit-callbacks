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
import com.example.exampleapi.databinding.FragmentTeamsBinding
import com.example.exampleapi.models.MainForStadings
import com.example.exampleapi.models.MainResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TeamsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_teams, container, false)
        val binding = FragmentTeamsBinding.bind(view)
        var adapter = TeamsAdapter()
        val recyclerView = binding.teamRV
        recyclerView.adapter = adapter
        var id = arguments?.getString("id").toString()
        var year = arguments?.getString("year").toString()
       binding.title.text = year

        var api = Network.getRetrofit(requireContext()).create(apiHelper::class.java)

        api.getitemStadings(id , year).enqueue(
            object : Callback<MainResponse<MainForStadings>> {
                override fun onResponse(
                    call: Call<MainResponse<MainForStadings>>,
                    response: Response<MainResponse<MainForStadings>>
                ) {
                    if (response.isSuccessful && response.code() == 200 ){
                        binding.progressBar.visibility = View.GONE
                        adapter.submitList(response.body()?.data?.standings ?: arrayListOf())
                        Log.d("AAA1" , "${response.body().toString()}")
                    }

                }

                override fun onFailure(call: Call<MainResponse<MainForStadings>>, t: Throwable) {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Error on Network", Toast.LENGTH_SHORT).show()
                }

            }
        )

        adapter.initListener {
            var bundle = Bundle()
            bundle.putSerializable("data" , it.stats)
            bundle.putString("name" , it.team.name)
            findNavController().navigate(R.id.action_teamsFragment_to_infoFragment , bundle)
        }

        return view
    }

}