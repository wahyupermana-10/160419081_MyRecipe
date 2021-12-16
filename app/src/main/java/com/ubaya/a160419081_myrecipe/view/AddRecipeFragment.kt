package com.ubaya.a160419081_myrecipe.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ubaya.a160419081_myrecipe.R
import com.ubaya.a160419081_myrecipe.databinding.FragmentAddRecipeBinding
import com.ubaya.a160419081_myrecipe.databinding.FragmentEditRecipeBinding
import com.ubaya.a160419081_myrecipe.model.Recipe
import com.ubaya.a160419081_myrecipe.viewmodel.DetailRecipeViewModel
import kotlinx.android.synthetic.main.fragment_add_recipe.*


class AddRecipeFragment : Fragment(), ButtonAddClickListener{
    private lateinit var viewModel:DetailRecipeViewModel
    private lateinit var dataBinding: FragmentAddRecipeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_recipe, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailRecipeViewModel::class.java)
        dataBinding.recipe= Recipe("","","","","")
        dataBinding.listener = this
    }

    override fun onButtonAddClick(v: View) {
        viewModel.addRecipe(dataBinding.recipe!!)
        val action = AddRecipeFragmentDirections.actionHome()
        Navigation.findNavController(v).navigate(action)
    }

}