package com.example.elixirgamefranklinjimenez.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGames(gameEntityList: List<GameEntity>)

    @Query("SELECT * FROM game_table")
    suspend fun getAllGames() : LiveData<List<GameEntity>>

    @Query("SELECT * FROM game_table WHERE id=id")
    suspend fun getAGame(id:Int): LiveData<GameEntity>
}
