package com.ubaya.a160419081_myrecipe.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ubaya.a160419081_myrecipe.R
import kotlinx.android.synthetic.main.fragment_edit_recipe.*

class EditRecipeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null){
            val name = EditRecipeFragmentArgs.fromBundle(requireArguments()).name
            val bahan = EditRecipeFragmentArgs.fromBundle(requireArguments()).bahan
            val langkah2 = EditRecipeFragmentArgs.fromBundle(requireArguments()).langkahlangkah
            val url = EditRecipeFragmentArgs.fromBundle(requireArguments()).url

            txtEditNameRecipe.setText(name)
            txtEditBahan.setText(bahan)
            txtEditLangkahLangkah.setText(langkah2)
            txtEditUrl.setText(url)
        }
        btnEdit.setOnClickListener {
            Toast.makeText(activity, "Recipe Berhasil di Ubah", Toast.LENGTH_SHORT).show()
        }
    }
}