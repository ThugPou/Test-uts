package com.example.utstest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.utstest.R
import com.example.utstest.data.DataBerita

class FragmentDetailBerita : Fragment() {
    lateinit var imageView: ImageView
    lateinit var txtTitle: TextView
    lateinit var txtDesc: TextView

    fun newInstance(data: DataBerita): FragmentDetailBerita? {
        val fragmentDemo = FragmentDetailBerita()
        val args = Bundle()

        args.putString("title", data.title)
        args.putString("img", data.imageUrl)
        args.putString("desc", data.desc)
        fragmentDemo.setArguments(args)
        return fragmentDemo
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_berita, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView = view.findViewById(R.id.imageView)
        txtTitle = view.findViewById(R.id.txtTitle)
        txtDesc = view.findViewById(R.id.txtDesc)

        var bundle = arguments

        Glide.with(requireActivity()).load(bundle?.getString("img","")).into(imageView)
        txtTitle.setText(bundle?.getString("title",""))
        txtDesc.setText(bundle?.getString("desc",""))

    }
}