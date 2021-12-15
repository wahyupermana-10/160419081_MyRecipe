package com.ubaya.a160419081_myrecipe.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.ubaya.a160419081_myrecipe.R
import com.ubaya.a160419081_myrecipe.model.Global
import kotlinx.android.synthetic.main.fragment_login.*
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)

        btnLogin.setOnClickListener {
            Global.txtUsername.clear()
            Global.txtUsername.add(txtInputUsername.text.toString())

            val queue = Volley.newRequestQueue(this)
            val url = "http://10.0.2.2/mylulus01/login.php"
            val stringRequest = object : StringRequest(
                Request.Method.POST,
                url,
                Response.Listener {
                    val obj = JSONObject(it)
                    if(obj.getString("result") == "OK"){
                        Log.d("login success", it)
                        Toast.makeText(applicationContext, "Login Valid", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }
                    else if(obj.getString("result") == "ERROR"){
                        Toast.makeText(applicationContext, "Login Invalid", Toast.LENGTH_SHORT).show()
                        Log.e("login failed", it.toString())
                    }

                },
                Response.ErrorListener {
                    Toast.makeText(applicationContext, "Login Invalid", Toast.LENGTH_SHORT).show()
                    Log.e("login failed", it.toString())
                }
            ) {
                override fun getParams(): MutableMap<String, String> {
                    val params = HashMap<String, String>()
                    params["username"] = txtInputUsername.text.toString()
                    params["pin"] = txtInputPass.text.toString()
                    return params
                }
            }
            queue.add(stringRequest)
        }
    }
}