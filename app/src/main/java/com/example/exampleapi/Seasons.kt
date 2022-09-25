package com.example.exampleapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.exampleapi.databinding.ActivitySeasonsBinding
import com.example.exampleapi.models.MainForSeasons
import com.example.exampleapi.models.MainResponse
import com.example.exampleapi.models.SeasonData
import com.example.exampleapi.models.TeamData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Seasons : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivitySeasonsBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}