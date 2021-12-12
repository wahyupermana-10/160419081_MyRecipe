package com.ubaya.a160419081_myrecipe.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg recipe: Recipe)

    @Query("SELECT * FROM recipe")
    suspend fun selectAllRecipe():List<Recipe>

    @Query("SELECT * FROM recipe WHERE uuid = :id")
    suspend fun selectRecipe(id:Int):Recipe
}