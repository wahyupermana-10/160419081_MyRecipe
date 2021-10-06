package com.ubaya.a160419081_myrecipe.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ubaya.a160419081_myrecipe.R
import com.ubaya.a160419081_myrecipe.util.loadImage
import kotlinx.android.synthetic.main.fragment_detail_recipe.*
import kotlinx.android.synthetic.main.fragment_detail_recipe.view.*
import kotlinx.android.synthetic.main.fragment_edit_recipe.*

class DetailRecipeFragment : Fragment() {

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
            val name = DetailRecipeFragmentArgs.fromBundle(requireArguments()).name
            val bahan = DetailRecipeFragmentArgs.fromBundle(requireArguments()).bahan
            val langkah2 = DetailRecipeFragmentArgs.fromBundle(requireArguments()).langkahlangkah
            val url = DetailRecipeFragmentArgs.fromBundle(requireArguments()).url

            txtNameRecipeDetail.text = "$name"
            txtDetailBahan.text = "$bahan"
            txtDetailLangkahLangkah.text = "$langkah2"
            view.imageView2.loadImage(url,view.progressBarDetailRecipe)

            btnUbah.setOnClickListener {
                val action = DetailRecipeFragmentDirections.actionEditRecipe(name,bahan,langkah2,url)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}