package com.example.utstest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.utstest.data.DataBerita
import com.example.utstest.fragment.FragmentBerita
import com.example.utstest.fragment.FragmentDetailBerita

class HalamanBerita : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_berita)

        var fm = supportFragmentManager.beginTransaction()
        fm.add(R.id.containerLayout, FragmentBerita())
        fm.commit()
    }

    fun pindahHalamanDetail(data: DataBerita) {
        var halamanDetail = FragmentDetailBerita();
        var bundle = Bundle();

        halamanDetail.arguments = bundle

        var fm = supportFragmentManager.beginTransaction()
        fm.replace(R.id.containerLayout, FragmentDetailBerita()?.newInstance(data)!!)
        fm.addToBackStack(null)
        fm.commit()

        Log.e("E","Pindah")

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