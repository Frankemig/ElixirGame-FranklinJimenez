package com.example.elixirgamefranklinjimenez

import com.example.elixirgamefranklinjimenez.remoto.Game
import com.example.elixirgamefranklinjimenez.remoto.GameDetails
import com.example.elixirgamefranklinjimenez.room.GameDetailEntity
import com.example.elixirgamefranklinjimenez.room.GameEntity

fun converterApiToDataB(game : Game): GameEntity{
    return GameEntity(
        game.id,
        game.name,
        game.background_image,
        game.released,
        game.rating,
        game.metacritic
    )
}

fun converterDataBToApi(gameEntity: GameEntity): Game{
    return Game(
        gameEntity.id,
        gameEntity.name,
        gameEntity.background_image,
        gameEntity.released,
        gameEntity.rating,
        gameEntity.metacritic
    )
}
fun converterDetailApiToData(gameDetails: GameDetails):GameDetailEntity{
    return GameDetailEntity(
        gameDetails.id,
        gameDetails.name,
        gameDetails.released,
        gameDetails.background_image,
        gameDetails.rating,
        gameDetails.metacritic,
        gameDetails.playtime,
        gameDetails.platforms,
        gameDetails.genres,
        gameDetails.format,
        gameDetails.lastPrice,
        gameDetails.lastPrice,
        gameDetails.delivery
    )
}
fun converteDetailDataToApi(gameDetailEntity: GameDetailEntity): GameDetails{
    return GameDetails(
        gameDetailEntity.id,
        gameDetailEntity.name,
        gameDetailEntity.released,
        gameDetailEntity.background_image,
        gameDetailEntity.rating,
        gameDetailEntity.metacritic,
        gameDetailEntity.playtime,
        gameDetailEntity.platforms,
        gameDetailEntity.genres,
        gameDetailEntity.format,
        gameDetailEntity.lastPrice,
        gameDetailEntity.lastPrice,
        gameDetailEntity.delivery
    )
}