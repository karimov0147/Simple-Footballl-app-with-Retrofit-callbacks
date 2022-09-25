package com.example.exampleapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exampleapi.databinding.ActivityInfoBinding
import com.example.exampleapi.models.Stats

class Info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)







    }
}