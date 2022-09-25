package com.example.exampleapi.models

import com.google.gson.annotations.SerializedName

data class MainResponse<T> (
    @SerializedName("status")
    val status : Boolean,
    @SerializedName("data")
    val data  : T
)