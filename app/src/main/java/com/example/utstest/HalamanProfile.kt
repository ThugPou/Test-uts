package com.example.utstest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.log

class HalamanProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_profile)

        val txtemail = findViewById<TextView>(R.id.txt_email)
        val txtnim = findViewById<TextView>(R.id.txt_nim)
        val txtnama = findViewById<TextView>(R.id.txt_nama)
        val txtkelas = findViewById<TextView>(R.id.txt_kelas)
        val btnlogout = findViewById<Button>(R.id.btn_logout)

        val sharePreference = getSharedPreferences("MY_PREF", Context.MODE_PRIVATE)

        val email = sharePreference.getString("EMAIL", "").toString()
        val nama = sharePreference.getString("NAMA", "").toString()
        val nim = sharePreference.getString("NIM", "").toString()
        val kelas = sharePreference.getString("KELAS", "").toString()

        txtemail.text = "$email"
        txtnama.text = "$nama"
        txtnim.text = "$nim"
        txtkelas.text = "$kelas"

        btnlogout.setOnClickListener{
            val logout = Intent(this, MainActivity::class.java)
            startActivity(logout)
        }
    }

    fun clickHome(view: View) {
        val hom = Intent(this,HalamanUtama::class.java);
        startActivity(hom);
    }
}