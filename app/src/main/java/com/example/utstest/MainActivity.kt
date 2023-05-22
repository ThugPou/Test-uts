package com.example.utstest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnlogin = findViewById<Button>(R.id.btn_login);
        val txtemail = findViewById<EditText>(R.id.txt_email)
        val txtpassword = findViewById<EditText>(R.id.txt_password)

        val sharePreference = getSharedPreferences("MY_PREF", Context.MODE_PRIVATE)

        btnlogin.setOnClickListener{
            val email = txtemail.text.toString()
            val password = txtpassword.text.toString()

            if(email == "ardy@gmail.com" && password == "12345"){
                val editor = sharePreference.edit()
                editor.putString("EMAIL", email)
                editor.putString("PASSWORD", password)
                editor.putString("NAMA", "Muhammad Ardy Dzakwan")
                editor.putString("NIM", "2107411048")
                editor.putString("KELAS", "TI 4B")
                editor.apply()
                editor.commit()

                val next = Intent(this, HalamanProfile::class.java)
                startActivity(next)
            } else {
                Toast.makeText(applicationContext, "Data Login Salah", Toast.LENGTH_SHORT).show()
            }
        }

    }
}