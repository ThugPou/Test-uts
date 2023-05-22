package com.example.utstest

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.utstest.adapter.UserAdapter
import com.example.utstest.data.AppDatabase
import com.example.utstest.data.entity.User
import com.example.utstest.R

class DataAlumniMahasiswa : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var list = mutableListOf<User>()
    private lateinit var adapter: UserAdapter
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_alumni_mahasiswa)

        recyclerView = findViewById(R.id.recycler_view)

        database = AppDatabase.getInstance(applicationContext)
        adapter = UserAdapter(list)
        adapter.setDialog(object : UserAdapter.Dialog{
            override fun onClick(position: Int) {
                val dialog = AlertDialog.Builder(this@DataAlumniMahasiswa)
                dialog.setTitle(list[position].fullName)
                dialog.setItems(R.array.items_option, DialogInterface.OnClickListener{dialog, which ->
                    if(which == 0){
                        val detail = Intent(this@DataAlumniMahasiswa,TambahDataMahasiswa::class.java)
                        detail.putExtra("id", list[position].uid)
                        startActivity(detail)
                    } else if (which == 1){
                        database.userDao().delete(list[position])
                        getData()
                    } else {
                        dialog.dismiss()
                    }
                })
                val dialogView = dialog.create()
                dialogView.show()
            }
        })

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(applicationContext, VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(applicationContext, VERTICAL))
    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun getData(){
        list.clear()
        list.addAll(database.userDao().getAll())
        adapter.notifyDataSetChanged()
    }
}