package com.example.elixirgamefranklinjimenez.remoto

import android.widget.ImageView

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
    val delivery : Boolean,
    //val deliverySi : String = "https://firebasestorage.googleapis.com/v0/b/instructivo-fed0b.appspot.com/o/Feliz.png?alt=media&token=9d3d791d-5567-4986-b83c-a9f58ee2a7b7",
    //val DeliveryNo : String = "https://firebasestorage.googleapis.com/v0/b/instructivo-fed0b.appspot.com/o/Triste.png?alt=media&token=3a4312ef-afa7-4045-9f98-12178e462504"
)