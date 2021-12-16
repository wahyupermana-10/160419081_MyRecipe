package com.ubaya.a160419081_myrecipe.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ubaya.a160419081_myrecipe.R
import com.ubaya.a160419081_myrecipe.databinding.FragmentDetailRecipeBinding
import com.ubaya.a160419081_myrecipe.util.NotificationHelper
import com.ubaya.a160419081_myrecipe.util.loadImage
import com.ubaya.a160419081_myrecipe.viewmodel.DetailRecipeViewModel
import kotlinx.android.synthetic.main.fragment_detail_recipe.*
import kotlinx.android.synthetic.main.fragment_detail_recipe.view.*
import kotlinx.android.synthetic.main.fragment_edit_recipe.*
import java.util.concurrent.TimeUnit

class DetailRecipeFragment : Fragment(), ButtonNotificationClickListener {
    private lateinit var viewModel:DetailRecipeViewModel
    private lateinit var dataBinding: FragmentDetailRecipeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentDetailRecipeBinding>(inflater, R.layout.fragment_detail_recipe, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailRecipeViewModel::class.java)
        val uuid = DetailRecipeFragmentArgs.fromBundle(requireArguments()).uuid
        viewModel.fetch(uuid)
        dataBinding.listener = this
        observerViewModel()
    }

    fun observerViewModel(){
        viewModel.recipeLD.observe(viewLifecycleOwner, Observer {
            dataBinding.recipe = it
            imageView2.loadImage(it.photoUrl.toString(), progressBarDetailRecipe)
        })
    }

    override fun onButtonNotificationClick(v: View) {

    }
}