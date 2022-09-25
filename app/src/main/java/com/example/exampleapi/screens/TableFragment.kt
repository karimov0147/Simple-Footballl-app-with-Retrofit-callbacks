package com.example.exampleapi.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.exampleapi.Network
import com.example.exampleapi.R
import com.example.exampleapi.apiHelper
import com.example.exampleapi.databinding.FragmentTableBinding
import com.example.exampleapi.databinding.TableItemBinding
import com.example.exampleapi.models.MainForStadings
import com.example.exampleapi.models.MainResponse
import com.example.exampleapi.models.Standings
import com.example.exampleapi.models.Stats
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TableFragment : Fragment() {

    lateinit var bind : TableItemBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_table, container, false)
        val binding = FragmentTableBinding.bind(view)
        var group = binding.tableView as TableLayout
        var array = ArrayList<Standings>()

        var id = arguments?.getString("id").toString()
        var year = arguments?.getString("year").toString()

//        for (it in 0..30){
//            var vi = LayoutInflater.from(requireContext()).inflate(R.layout.table_item , binding.tableView , false)
//            group.addView(vi)
//        }


        var api = Network.getRetrofit(requireContext()).create(apiHelper::class.java)

        api.getitemStadings(id , year).enqueue(
            object : Callback<MainResponse<MainForStadings>> {
                override fun onResponse(
                    call: Call<MainResponse<MainForStadings>>,
                    response: Response<MainResponse<MainForStadings>>
                ) {
                    if (response.isSuccessful && response.code() == 200 ){

                               array.clear()
                               array.addAll(response.body()?.data?.standings!!)
                               array.forEach {

                                   var item = LayoutInflater.from(requireContext()).inflate(R.layout.table_item , binding.tableView , false)
                                   bind = TableItemBinding.bind(item)
                                   bind.apply {
                                       name.text = it.team.name
                                       wins.text = it.stats[0].value
                                       losses.text = it.stats[1].value
                                       draws.text = it.stats[2].value
                                       gamesPlayed.text = it.stats[3].value
                                       goalsFor.text = it.stats[4].value
                                       goalsAginst.text = it.stats[5].value
                                       points.text = it.stats[6].value
                                       rankChange.text = it.stats[7].value
                                       rank.text = it.stats[8].value
                                       GoalDiffernce.text = it.stats[9].value
                                       pointsPG.text = it.stats[11].value
                                       overall.text = it.stats[12].value
                                       Glide.with(requireContext())
                                           .load(it.team.logos[0].image)
                                           .into(image)
                                   }
                                   group.addView(item)
                               }





                        binding.progressBar.visibility = View.GONE


                        Log.d("AAA1" , "${response.body().toString()}")
                    }

                }

                override fun onFailure(call: Call<MainResponse<MainForStadings>>, t: Throwable) {
                   binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Error on Network", Toast.LENGTH_SHORT).show()
                }



            }
        )


        return view
    }

}