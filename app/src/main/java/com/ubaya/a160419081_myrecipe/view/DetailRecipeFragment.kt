package com.ubaya.a160419081_myrecipe.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ubaya.a160419081_myrecipe.R
import com.ubaya.a160419081_myrecipe.util.loadImage
import com.ubaya.a160419081_myrecipe.viewmodel.DetailRecipeViewModel
import kotlinx.android.synthetic.main.fragment_detail_recipe.*
import kotlinx.android.synthetic.main.fragment_detail_recipe.view.*
import kotlinx.android.synthetic.main.fragment_edit_recipe.*

class DetailRecipeFragment : Fragment() {
    private lateinit var viewModel:DetailRecipeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null){
            viewModel = ViewModelProvider(this).get(DetailRecipeViewModel::class.java)
            val uuid = DetailRecipeFragmentArgs.fromBundle(requireArguments()).uuid
            viewModel.fetch(uuid)
        }

        observerViewModel()
    }

    fun observerViewModel(){
        viewModel.recipeLD.observe(viewLifecycleOwner, Observer {
            txtInputName.setText(it.recipeName)
            txtAlatdanBahan.setText(it.bahan)
            txtInputLangkahLangkah.setText(it.langkahLangkah)
            txtInputURL.setText(it.photoUrl)
            imageView2.loadImage(it.photoUrl.toString(), progressBarDetailRecipe)
        })
    }
}