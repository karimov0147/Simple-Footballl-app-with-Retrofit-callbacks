package com.example.exampleapi.models

import com.google.gson.annotations.SerializedName

data class MainForStadings(
    @SerializedName("name")
    var name  :String,
    @SerializedName("standings")
    var standings : ArrayList<Standings>
)