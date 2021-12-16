package com.ubaya.a160419081_myrecipe.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Recipe(
    @ColumnInfo(name = "recipeName")
    var recipeName:String,
    @ColumnInfo(name = "bahan")
    var bahan:String,
    @ColumnInfo(name = "langkahLangkah")
    var langkahLangkah:String,
    @ColumnInfo(name = "photourl")
    var photoUrl:String,
    @ColumnInfo(name = "recipeStory")
    var recipeStory: String,
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int = 0
}