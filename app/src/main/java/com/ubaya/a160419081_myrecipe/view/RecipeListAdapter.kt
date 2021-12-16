package com.ubaya.a160419081_myrecipe.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.a160419081_myrecipe.R
import com.ubaya.a160419081_myrecipe.databinding.RecipeListItemBinding
import com.ubaya.a160419081_myrecipe.model.Recipe
import com.ubaya.a160419081_myrecipe.util.loadImage
import kotlinx.android.synthetic.main.recipe_list_item.view.*

class RecipeListAdapter (val recipeList: ArrayList<Recipe>, val adapterOnClick:(Any)-> Unit): RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>(), ButtonDetailClickListener, ButtonUbahClickListener, ButtonDeleteClickListener{
    class RecipeViewHolder(val view: RecipeListItemBinding):RecyclerView.ViewHolder(view.root)

    fun updateRecipeList(newRecipeList: List<Recipe>){
        recipeList.clear()
        recipeList.addAll(newRecipeList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val v = DataBindingUtil.inflate<RecipeListItemBinding>(inflate, R.layout.recipe_list_item, parent,false)
        return RecipeViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.view.recipe = recipeList[position]
        holder.view.listener = this
        holder.view.listener2 = this
        holder.view.listener3 = this
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    override fun onButtonDetailClick(v: View) {
        val action = RecipesListFragmentDirections.actionDetailRecipe(v.tag.toString().toInt())
        Navigation.findNavController(v).navigate(action)
    }

    override fun onButtonUbahClick(v: View) {
        val action = RecipesListFragmentDirections.actionUbah(v.tag.toString().toInt())
        Navigation.findNavController(v).navigate(action)
    }

    override fun onButtonDeleteClick(v: View, obj: Recipe) {
        adapterOnClick(obj)
    }
}