package com.example.exampleapi

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.exampleapi.databinding.ActivityTeamsBinding
import com.example.exampleapi.models.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Teams : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTeamsBinding.inflate(layoutInflater)
        setContentView(binding.root)







    }
}