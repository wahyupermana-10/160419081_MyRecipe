package com.ubaya.a160419081_myrecipe.model

import androidx.room.*

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg recipe: Recipe)

    @Query("SELECT * FROM recipe")
    suspend fun selectAllRecipe():List<Recipe>

    @Query("SELECT * FROM recipe WHERE uuid = :id")
    suspend fun selectRecipe(id:Int):Recipe

    @Query("UPDATE recipe SET recipeName= :recipeName, bahan=:bahan, langkahLangkah=:langkahLangkah, photoURL=:photoURL")
    suspend fun update(recipeName:String, bahan:String, langkahLangkah:String, photoURL:String)

    @Delete
    suspend fun deleteRecipe(recipe:Recipe)
}