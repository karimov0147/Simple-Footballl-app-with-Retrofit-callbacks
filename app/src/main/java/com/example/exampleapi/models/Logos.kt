package com.example.exampleapi.models

import com.google.gson.annotations.SerializedName

data class Logos(
    @SerializedName("light")
    var light : String,
    @SerializedName("night")
    var night : String
)
