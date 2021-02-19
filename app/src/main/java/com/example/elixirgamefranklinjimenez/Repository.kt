package com.example.elixirgamefranklinjimenez

import android.content.Context
import com.example.elixirgamefranklinjimenez.room.GameDataBase

class Repository (context: Context) {

    var gameDataBase = GameDataBase.getDatabase(context)
    var gameList = gameDataBase.getGameDao().getAllGames()
}