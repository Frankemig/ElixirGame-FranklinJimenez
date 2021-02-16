package com.example.elixirgamefranklinjimenez.remoto

data class Game (
    val id : Int,
    val name : String,
    val released : String,
    val background_image : String,
    val rating : Double,
    val metacritic : Int
    )
data class GameDetails(
    val id : Int,
    val name : String,
    val released : String,
    val background_image : String,
    val rating : Double,
    val metacritic : Int,
    val playtime : Int,
    val platforms : String,
    val genres : String,
    val format : String,
    val price : String,
    val lastPrice : String,
    val delivery : Boolean
)