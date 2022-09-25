package com.example.exampleapi

import com.example.exampleapi.models.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface apiHelper {

@GET("/leagues")
fun getLeagues() : Call<MainResponse<ArrayList<TeamData>>>

@GET("/leagues/{id}")
fun getLeaguesItem(@Path("id") id : String) : Call<MainResponse<TeamData>>

@GET("/leagues/{id}/seasons")
fun getItemSeasons(@Path("id") id : String) : Call<MainResponse<MainForSeasons>>

@GET("/leagues/{id}/standings")
fun getitemStadings(@Path("id") id : String , @Query("season") year : String) : Call<MainResponse<MainForStadings>>

}