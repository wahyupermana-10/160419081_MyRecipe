package com.ubaya.a160419081_myrecipe.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ubaya.a160419081_myrecipe.R
import com.ubaya.a160419081_myrecipe.viewmodel.DetailRecipeViewModel
import kotlinx.android.synthetic.main.fragment_edit_recipe.*

class EditRecipeFragment : Fragment() {

    private lateinit var viewModel: DetailRecipeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailRecipeViewModel::class.java)
        val uuid = EditRecipeFragmentArgs.fromBundle(requireArguments()).uuid
        viewModel.fetch(uuid)
        observeViewModel()
//        if(arguments != null){
//            val name = EditRecipeFragmentArgs.fromBundle(requireArguments()).name
//            val bahan = EditRecipeFragmentArgs.fromBundle(requireArguments()).bahan
//            val langkah2 = EditRecipeFragmentArgs.fromBundle(requireArguments()).langkahlangkah
//            val url = EditRecipeFragmentArgs.fromBundle(requireArguments()).url
//
//            txtInputName.setText(name)
//            txtAlatdanBahan.setText(bahan)
//            txtInputLangkahLangkah.setText(langkah2)
//            txtInputURL.setText(url)
//        }
        btnEdit.setOnClickListener {
            Toast.makeText(activity, "Recipe Berhasil di Ubah", Toast.LENGTH_SHORT).show()
        }
    }

    fun observeViewModel(){
        viewModel.recipeLD.observe(viewLifecycleOwner, Observer {
            txtInputName.setText(it.recipeName)
            txtAlatdanBahan.setText(it.bahan)
            txtInputLangkahLangkah.setText(it.langkahLangkah)
            txtInputURL.setText(it.photoUrl)
        })
    }
}