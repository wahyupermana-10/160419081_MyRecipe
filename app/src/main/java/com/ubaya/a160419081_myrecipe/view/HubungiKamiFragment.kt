package com.ubaya.a160419081_myrecipe.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ubaya.a160419081_myrecipe.R
import kotlinx.android.synthetic.main.fragment_hubungi_kami.*

class HubungiKamiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hubungi_kami, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var isiEmail = txtAduan.text
        btnAduan.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf("myRecipe.Aduan@mail.com"))
                putExtra(Intent.EXTRA_SUBJECT,"Bug Aplikasi MyRecipe")
                putExtra(Intent.EXTRA_TEXT, isiEmail.toString())
                type = "message/rfc822"
                `package` = "com.google.android.gm"
            }
            val shareIntent = Intent.createChooser(sendIntent, "Kirim Email")
            startActivity(shareIntent)
        }
    }
}