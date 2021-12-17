package com.ubaya.a160419081_myrecipe.view

import android.view.View
import com.ubaya.a160419081_myrecipe.model.Recipe

interface ButtonDetailClickListener{
    fun onButtonDetailClick(v:View)
}

interface ButtonUbahClickListener{
    fun onButtonUbahClick(v:View)
}

interface ButtonAddClickListener{
    fun onButtonAddClick(v:View)
}

interface ButtonEditClickListener{
    fun onButtonEditClick(v:View, obj: Recipe)
}

interface ButtonDeleteClickListener{
    fun onButtonDeleteClick(v:View, obj:Recipe)
}

interface ButtonNotificationClickListener{
    fun onButtonNotificationClick(v:View)
}

interface ButtonLoginClickListener{
    fun onButtonLoginClick(v: View)
}

interface ButtonNotHaveAccClickListener{
    fun onButtonNotHaveAccClick(v: View)
}

interface ButtonRegisterClickListener{
    fun onButtonRegisterClick(v: View)
}

interface ButtonHaveAccountClickListener{
    fun onButtonHaveAccountClick(v: View)
}