package com.example.elixirgamefranklinjimenez

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elixirgamefranklinjimenez.remoto.Game
import com.example.elixirgamefranklinjimenez.remoto.GameDetails
import com.example.elixirgamefranklinjimenez.remoto.RetrofitClient
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {

    private lateinit var selected : Game
    private val gameList = MutableLiveData<List<Game>>()

    fun gameList(): LiveData<List<Game>> = gameList

    fun getGames() {
        viewModelScope.launch {
            val response = RetrofitClient.retrofitInstance().getGames()
            Log.d("GameViewModel", "cargando info")

            response.let {
                when (it.isSuccessful) {
                    true -> gameList.value = response.body()
                    false -> Log.d("GameViewModel", "error")
                }
            }
            Log.d("GameViewModel", response.body().toString())
        }
    }
    private val detail = MutableLiveData<GameDetails>()


    fun getGame(): LiveData<GameDetails> = detail



    fun getGame(id: Int){

        viewModelScope.launch {
            val response = RetrofitClient.retrofitInstance().getGame(id)

            when (response.isSuccessful) {

                true -> detail.value = response.body()
                false -> Log.d("GameViewModel", "error en el detalle ${response.code()}")

            }
        }

    }

    fun setSelected(game: Game) {
        selected = game
        Log.d("ViewModel", game.toString())

    }

}
