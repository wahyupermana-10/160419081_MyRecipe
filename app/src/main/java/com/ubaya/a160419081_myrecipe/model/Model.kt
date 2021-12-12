package com.ubaya.a160419081_myrecipe.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Recipe(
    @ColumnInfo(name = "recipeName")
    val recipeName:String?,
    @ColumnInfo(name = "bahan")
    val bahan:String?,
    @ColumnInfo(name = "langkah-langkah")
    val langkahLangkah:String?,
    @ColumnInfo(name = "photourl")
    val photoUrl:String?
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int = 0
}