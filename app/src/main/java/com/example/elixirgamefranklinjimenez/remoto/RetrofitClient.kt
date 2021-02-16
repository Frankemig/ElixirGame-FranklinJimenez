package com.example.elixirgamefranklinjimenez.remoto

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://my-json-server.typicode.com/himuravidal/gamesDB/"

class RetrofitClient {
    companion object {
        fun retrofitInstance(): GameAPI {
            val retrofit = Retrofit.Builder()

                .baseUrl(BASE_URL)

                .addConverterFactory(GsonConverterFactory.create())

                .build()

            return retrofit.create(GameAPI::class.java)
        }
    }
}