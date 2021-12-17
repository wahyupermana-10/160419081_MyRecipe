package com.ubaya.a160419081_myrecipe.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ubaya.a160419081_myrecipe.R
import com.ubaya.a160419081_myrecipe.databinding.FragmentLoginBinding
import com.ubaya.a160419081_myrecipe.model.User
import com.ubaya.a160419081_myrecipe.viewmodel.ListUserViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_profile.*

class LoginFragment : Fragment(), ButtonLoginClickListener, ButtonNotHaveAccClickListener {

    private lateinit var viewModel: ListUserViewModel
    private lateinit var dataBinding : FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater,R.layout.fragment_login, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListUserViewModel::class.java)
        dataBinding.listener=this
        dataBinding.listener2=this
    }

    override fun onButtonLoginClick(v: View) {
        viewModel.fetch(txtInputUsername.text.toString(), txtInputPass.text.toString())
        if (viewModel.userLD.value?.email == txtInputUsername.text.toString()){
            viewModel.updateActive(txtInputUsername.text.toString())
            val action = LoginFragmentDirections.actionHome()
            Navigation.findNavController(v).navigate(action)
            Toast.makeText(activity, "Login Sukses", Toast.LENGTH_SHORT).show()
        }
        else
        {
            Toast.makeText(activity, "Login Gagal", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onButtonNotHaveAccClick(v: View) {
        val action = LoginFragmentDirections.actionRegister()
        Navigation.findNavController(v).navigate(action)
    }
}