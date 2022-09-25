package com.example.exampleapi.models

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("name")
    var name : String,
    @SerializedName("logos")
    var logos : ArrayList<LogosTeam>
)
