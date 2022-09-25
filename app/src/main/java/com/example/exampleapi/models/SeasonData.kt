package com.example.exampleapi.models

import com.google.gson.annotations.SerializedName

data class SeasonData(
    @SerializedName("year")
    var year : Int,
    @SerializedName("startDate")
    var startDate :String,
    @SerializedName("endDate")
    var endDate :String,
    @SerializedName("displayName")
    var displayName :String
)