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

@Entity
data class User(
    @ColumnInfo(name = "nama")
    var nama:String,
    @ColumnInfo(name = "phoneNumber")
    var phoneNumber:String,
    @ColumnInfo(name = "email")
    var email:String,
    @ColumnInfo(name = "password")
    var password:String,
    @ColumnInfo(name = "active")
    var active:Int
){
    @PrimaryKey(autoGenerate = true)
    var userId:Int = 0
}