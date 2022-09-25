package com.example.exampleapi.screens

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.exampleapi.*
import com.example.exampleapi.databinding.CustomDialogBinding
import com.example.exampleapi.databinding.FragmentLeaguesBinding
import com.example.exampleapi.models.MainResponse
import com.example.exampleapi.models.TeamData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LeaguesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_leagues, container, false)
        val binding = FragmentLeaguesBinding.bind(view)
        var recyclerView = binding.recyclerView
        var adapter = MyAdapter()
        recyclerView.adapter =adapter

        var api = Network.getRetrofit(requireContext()).create(apiHelper::class.java)

        api.getLeagues().enqueue(
            object : Callback<MainResponse<ArrayList<TeamData>>> {
                override fun onResponse(
                    call: Call<MainResponse<ArrayList<TeamData>>>,
                    response: Response<MainResponse<ArrayList<TeamData>>>
                ) {
                    if (response.isSuccessful && response.code() == 200 ){
                        binding.progressBar.visibility = View.GONE
                        adapter.submitList(response.body()?.data ?: arrayListOf())
                    }

                }

                override fun onFailure(call: Call<MainResponse<ArrayList<TeamData>>>, t: Throwable) {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Error on Network", Toast.LENGTH_SHORT).show()
                }

            }
        )



        adapter.initClickListener {

            binding.progressBar.visibility = View.VISIBLE

            api.getLeaguesItem(it).enqueue(
                object : Callback<MainResponse<TeamData>> {
                    override fun onResponse(
                        call: Call<MainResponse<TeamData>>,
                        response: Response<MainResponse<TeamData>>
                    ) {
                        if (response.isSuccessful && response.code() == 200){
                            binding.progressBar.visibility = View.GONE
                            var custom = View.inflate(requireContext() , R.layout.custom_dialog , null)
                            var itemBind = CustomDialogBinding.bind(custom)
                            var builder = AlertDialog.Builder(requireContext())
                                .setView(custom)
                                .create()
                            itemBind.apply {
                                textinfo.text = response.body()?.data?.abbr
                                Glide.with(imageFilterView2)
                                    .load(response.body()?.data?.logos?.light)
                                    .placeholder(R.drawable.ic_launcher_background)
                                    .into(imageFilterView2)
                            }
                            builder.show()
                        }
                    }

                    override fun onFailure(call: Call<MainResponse<TeamData>>, t: Throwable) {
                        Toast.makeText(requireContext(), "not found item", Toast.LENGTH_SHORT).show()
                        binding.progressBar.visibility = View.GONE
                    }

                }
            )
        }


        adapter.initCArdClickListener { id , name ->
            var bundle = Bundle()
            bundle.putString("id" , id)
            bundle.putString("Name" , name)
            findNavController().navigate(R.id.action_leaguesFragment_to_seasonsFragment , bundle)

        }



        return view
    }

}