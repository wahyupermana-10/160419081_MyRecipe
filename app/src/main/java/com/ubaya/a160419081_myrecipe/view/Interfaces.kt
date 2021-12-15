package com.ubaya.a160419081_myrecipe.view

import android.view.View
import com.ubaya.a160419081_myrecipe.model.Recipe

interface ButtonDetailClickListener{
    fun onButtonDetailClick(v:View)
}

interface ButtonUbahClickListener{
    fun onButtonUbahClick(v:View)
}

interface ButtonEditClickListener{
    fun onButtonEditClick(v:View, obj: Recipe)
}

interface ButtonDeleteClickListener{
    fun onButtonDeleteClick(v:View, obj:Recipe)
}
