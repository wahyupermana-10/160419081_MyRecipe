package com.ubaya.a160419081_myrecipe.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ubaya.a160419081_myrecipe.R
import com.ubaya.a160419081_myrecipe.model.Recipe
import com.ubaya.a160419081_myrecipe.viewmodel.DetailRecipeViewModel
import kotlinx.android.synthetic.main.fragment_add_recipe.*


class AddRecipeFragment : Fragment() {
    private lateinit var viewModel:DetailRecipeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailRecipeViewModel::class.java)
        btnAdd.setOnClickListener {
            var recipe = Recipe(txtInputName.text.toString(), txtAlatdanBahan.text.toString(),txtInputLangkahLangkah.text.toString(),txtInputURL.text.toString())
            var list = listOf(recipe)
            viewModel.addRecipe(list)
            Toast.makeText(view.context,"Recipe added", Toast.LENGTH_LONG).show()
            Navigation.findNavController(it).popBackStack()
        }
    }
}