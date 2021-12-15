package com.ubaya.a160419081_myrecipe.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.ubaya.a160419081_myrecipe.model.Recipe
import com.ubaya.a160419081_myrecipe.model.RecipeDatabase
import com.ubaya.a160419081_myrecipe.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailRecipeViewModel (application: Application):AndroidViewModel(application),CoroutineScope{
    private val job = Job()
    val recipeLD = MutableLiveData<Recipe>()

    fun addRecipe(list: List<Recipe>){
        launch {
            val db = buildDb(getApplication())
            db.recipeDao().insertAll(*list.toTypedArray())
        }
    }

    fun fetch(uuid:Int){
        launch {
            val db = buildDb(getApplication())
            recipeLD.value = db.recipeDao().selectRecipe(uuid)
        }
    }

    fun update(recipeName:String, bahan:String, langkahLangah:String, photoURL: String, uuid: Int){
        launch {
            val db = buildDb(getApplication())
            db.recipeDao().update(recipeName, bahan, langkahLangah, photoURL, uuid)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

}