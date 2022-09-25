package com.example.exampleapi.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Stats(
    @SerializedName("displayName")
    var name : String,
    @SerializedName("displayValue")
    var value : String
): Serializable
