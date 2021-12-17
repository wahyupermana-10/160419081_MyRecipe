package com.ubaya.a160419081_myrecipe.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ubaya.a160419081_myrecipe.R
import com.ubaya.a160419081_myrecipe.databinding.FragmentRegisterBinding
import com.ubaya.a160419081_myrecipe.model.Recipe
import com.ubaya.a160419081_myrecipe.model.User
import com.ubaya.a160419081_myrecipe.viewmodel.ListUserViewModel
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment(), ButtonRegisterClickListener, ButtonHaveAccountClickListener {

    private lateinit var viewModel: ListUserViewModel
    private lateinit var dataBinding : FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentRegisterBinding>(inflater, R.layout.fragment_register, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =ViewModelProvider(this).get(ListUserViewModel::class.java)
        dataBinding.user= User("","","","",0)

        dataBinding.listener=this
        dataBinding.listener2=this

//        btnDaftar.setOnClickListener {
//            Toast.makeText(activity, "Register Berhasil", Toast.LENGTH_SHORT).show()
//            val action = RegisterFragmentDirections.actionLogin()
//            Navigation.findNavController(it).navigate(action)
//        }
//
//        btnSudahPunyaAkun.setOnClickListener {
//            val action = RegisterFragmentDirections.actionLogin()
//            Navigation.findNavController(it).navigate(action)
//        }
    }

    override fun onButtonRegisterClick(v: View) {
        if(txtReRegPas.text.toString() == txtRegPas.text.toString()){
            viewModel.addUser(dataBinding.user!!)
            val action = RegisterFragmentDirections.actionLogin()
            Navigation.findNavController(v).navigate(action)
        }
        else{
            Toast.makeText(activity, "Konfirmasi Password Tidak Sama", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onButtonHaveAccountClick(v: View) {
        val action = RegisterFragmentDirections.actionLogin()
        Navigation.findNavController(v).navigate(action)
    }

}