package com.example.exampleapi.models

import com.google.gson.annotations.SerializedName

data class MainForSeasons(
    @SerializedName("desc")
    var desc :String,
    @SerializedName("seasons")
    var seasons : ArrayList<SeasonData>
)
