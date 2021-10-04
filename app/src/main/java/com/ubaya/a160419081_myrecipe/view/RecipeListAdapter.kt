package com.ubaya.a160419081_myrecipe.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.a160419081_myrecipe.R
import com.ubaya.a160419081_myrecipe.model.Recipe
import kotlinx.android.synthetic.main.recipe_list_item.view.*

//class RecipeListAdapter (val recipeList: ArrayList<Recipe>):RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>(){
//    class RecipeViewHolder(val view: View):RecyclerView.ViewHolder(view)
//
//    fun updateRecipeLis(newRecipeList: List<Recipe>){
//        recipeList.clear()
//        recipeList.addAll(newRecipeList)
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
//        val inflate = LayoutInflater.from(parent.context)
//        val v = inflate.inflate(R.layout.recipe_list_item,parent,false)
//        return RecipeViewHolder(v)
//    }
//
//    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
//        holder.view.txtNameRecipe.text = recipeList[position].recipeName
//    }
//}