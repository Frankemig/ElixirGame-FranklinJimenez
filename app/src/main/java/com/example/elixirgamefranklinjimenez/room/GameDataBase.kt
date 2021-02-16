package com.example.elixirgamefranklinjimenez.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [GameEntity::class], version = 1)

abstract class GameDataBase : RoomDatabase(){
    abstract fun getGameDao() : GameDao

    companion object {
        // Singleton
        @Volatile
        private var INSTANCE: GameDataBase? = null

        fun getDatabase(context: Context): GameDataBase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GameDataBase::class.java,
                    "game_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}