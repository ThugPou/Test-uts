package com.example.utstest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HalamanProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_profile)
    }

    fun clickBerita(view: View) {
        val ber = Intent(this,HalamanBerita::class.java);
        startActivity(ber);
    }

    fun clickHome(view: View) {
        val hom = Intent(this,HalamanUtama::class.java);
        startActivity(hom);
    }

    fun clickProfile(view: View) {
        val prof = Intent(this,HalamanProfile::class.java);
        startActivity(prof);
    }
}