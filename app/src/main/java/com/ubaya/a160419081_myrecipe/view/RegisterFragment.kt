package com.ubaya.a160419081_myrecipe.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.ubaya.a160419081_myrecipe.R
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnDaftar.setOnClickListener {
            Toast.makeText(activity, "Register Berhasil", Toast.LENGTH_SHORT).show()
            val action = RegisterFragmentDirections.actionLogin()
            Navigation.findNavController(it).navigate(action)
        }

        btnSudahPunyaAkun.setOnClickListener {
            val action = RegisterFragmentDirections.actionLogin()
            Navigation.findNavController(it).navigate(action)
        }
    }

}