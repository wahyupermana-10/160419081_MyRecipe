package com.ubaya.a160419081_myrecipe.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Recipe::class), version = 1)
abstract class RecipeDatabase:RoomDatabase() {
    abstract fun recipeDao(): RecipeDao

    companion object{
        @Volatile private var instance: RecipeDatabase ?= null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                RecipeDatabase::class.java,
                "recipedb"
            ).build()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }
    }
}