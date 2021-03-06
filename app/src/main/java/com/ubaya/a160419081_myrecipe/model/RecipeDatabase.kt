package com.ubaya.a160419081_myrecipe.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ubaya.a160419081_myrecipe.util.MIGRATION_3_4
import com.ubaya.a160419081_myrecipe.util.Migration_4_5

@Database(entities = arrayOf(Recipe::class,User::class), version = 5)
abstract class RecipeDatabase:RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
    abstract fun userDao(): UserDao

    companion object{
        @Volatile private var instance: RecipeDatabase ?= null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                RecipeDatabase::class.java,
                "recipedb"
            ).addMigrations(MIGRATION_3_4, Migration_4_5).build()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }
    }
}