package com.example.elixirgamefranklinjimenez.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game_table")
data class GameEntity(
    @PrimaryKey val id : Int,
    val name : String,
    val released : String,
    val background_image : String,
    val rating : Double,
    val metacritic : Int
)

@Entity(tableName = "game_detail")
data class GameDetailEntity(
    @PrimaryKey val id : Int,
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