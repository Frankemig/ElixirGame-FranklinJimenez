package com.example.elixirgamefranklinjimenez.remoto

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GameAPI {
    @GET("games")
    suspend fun getGames(): Response<List<Game>>

    @GET("gameDetails/{id}")
    suspend fun getGame(@Path("id") id: Int): Response<GameDetails>

}