package com.example.exampleapi.models

import com.google.gson.annotations.SerializedName

data class TeamData(
    @SerializedName("id")
    var id : String,
    @SerializedName("name")
    var name : String,
    @SerializedName("slug")
    var slug : String,
    @SerializedName("abbr")
    var abbr :String,
    @SerializedName("logos")
    var logos : Logos
)