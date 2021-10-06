package com.ubaya.a160419081_myrecipe.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.a160419081_myrecipe.R
import com.ubaya.a160419081_myrecipe.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_recipes_list.*

class RecipesListFragment : Fragment() {
    private lateinit var viewModel: ListViewModel
    private val recipeListAdapter = RecipeListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = recipeListAdapter

        observerViewModel()
    }

    fun observerViewModel() {
        viewModel.recipeLD.observe(viewLifecycleOwner, {
            recipeListAdapter.updateRecipeList(it)
        })

        viewModel.loadingErrorLD.observe(viewLifecycleOwner, {
            txtError2.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, {
            if (it) {
                progressBar2.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
            } else {
                progressBar2.visibility = View.VISIBLE
                recyclerView.visibility = View.GONE
            }
        })
    }
}