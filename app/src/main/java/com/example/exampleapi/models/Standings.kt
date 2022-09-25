package com.example.exampleapi.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Standings(
    @SerializedName("team")
    var team : Team,
    @SerializedName("stats")
    var stats : ArrayList<Stats>
)
