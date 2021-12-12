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

class ListRecipeViewModel(application: Application):AndroidViewModel(application),CoroutineScope {
    val recipeLD = MutableLiveData<List<Recipe>>()
    val recipeLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    private var job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun refresh(){
        loadingLD.value = true
        recipeLoadErrorLD.value = false
        launch {
            val db = buildDb(getApplication())

            recipeLD.value = db.recipeDao().selectAllRecipe()
        }
    }
}