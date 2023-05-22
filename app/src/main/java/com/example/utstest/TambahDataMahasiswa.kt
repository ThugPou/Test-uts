package com.example.utstest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.utstest.data.AppDatabase
import com.example.utstest.data.entity.User

class TambahDataMahasiswa :  AppCompatActivity() {

    private lateinit var fullname: EditText
    private lateinit var email: EditText
    private lateinit var phone: EditText
    private lateinit var btnSave: Button
    private lateinit var database: AppDatabase
    var dalum = Intent(this,DataAlumniMahasiswa::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tambah_data_mahasiswa)

        fullname = findViewById(R.id.full_name)
        email = findViewById(R.id.email)
        phone = findViewById(R.id.phone)
        btnSave = findViewById(R.id.btn_save)

        database = AppDatabase.getInstance(applicationContext)
        val detail = intent.extras
        if (detail != null){
            val user = database.userDao().get(detail.getInt("id"))

            fullname.setText(user.fullName)
            email.setText(user.email)
            phone.setText(user.phone)
        }

        btnSave.setOnClickListener{
            if(fullname.text.isNotEmpty() && email.text.isNotEmpty() && phone.text.isNotEmpty()){
                if (detail != null){
                    database.userDao().update(User(
                        detail.getInt("id", 0),
                        fullname.text.toString(),
                        email.text.toString(),
                        phone.text.toString()
                    ))
                } else {
                    database.userDao().insertAll(User(
                        null,
                        fullname.text.toString(),
                        email.text.toString(),
                        phone.text.toString()
                    ))
                }
                startActivity(dalum)
            } else {
                Toast.makeText(applicationContext, "Isi Data Terlebih Dahulu", Toast.LENGTH_SHORT).show()
            }
        }
    }
}