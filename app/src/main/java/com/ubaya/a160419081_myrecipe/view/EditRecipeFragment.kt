package com.ubaya.a160419081_myrecipe.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ubaya.a160419081_myrecipe.R
import com.ubaya.a160419081_myrecipe.databinding.FragmentDetailRecipeBinding
import com.ubaya.a160419081_myrecipe.databinding.FragmentEditRecipeBinding
import com.ubaya.a160419081_myrecipe.model.Recipe
import com.ubaya.a160419081_myrecipe.viewmodel.DetailRecipeViewModel
import kotlinx.android.synthetic.main.fragment_edit_recipe.*

class EditRecipeFragment : Fragment(), ButtonEditClickListener {

    private lateinit var viewModel: DetailRecipeViewModel
    private lateinit var dataBinding: FragmentEditRecipeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentEditRecipeBinding>(inflater, R.layout.fragment_edit_recipe, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailRecipeViewModel::class.java)
        val uuid = EditRecipeFragmentArgs.fromBundle(requireArguments()).uuid
        viewModel.fetch(uuid)
        observeViewModel()

        dataBinding.listener = this
    }

    fun observeViewModel(){
        viewModel.recipeLD.observe(viewLifecycleOwner, Observer {
            dataBinding.recipe = it
        })
    }

    override fun onButtonEditClick(v: View, obj: Recipe) {
        viewModel.update(obj.recipeName,obj.bahan,obj.langkahLangkah,obj.photoUrl,obj.uuid)
        Toast.makeText(v.context, "Recipe updated", Toast.LENGTH_SHORT).show()
    }
}