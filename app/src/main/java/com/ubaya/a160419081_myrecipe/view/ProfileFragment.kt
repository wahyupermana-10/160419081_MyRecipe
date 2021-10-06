package com.ubaya.a160419081_myrecipe.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ubaya.a160419081_myrecipe.R
import com.ubaya.a160419081_myrecipe.util.loadImage
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*


class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txtName.setText("Risqi Wahyu Permana")
        txtBOD.setText("30/10/2001")
        txtEmail.setText("wahyupermana@gmail.com")
        txtPhone.setText("08219966042")

        view.imgProfile.loadImage("https://i.pinimg.com/564x/c0/f4/e7/c0f4e7315ee50243d43a5a30e869d282.jpg",view.progressBarProfile)
    }
}