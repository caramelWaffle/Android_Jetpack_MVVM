package com.example.totorial.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.totorial.R
import com.example.totorial.databinding.ActivityRecyclerViewBinding
import com.example.totorial.main.adapter.RecyclerViewAdapter

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view)
        binding.lifecycleOwner = this
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = RecyclerViewAdapter()
    }
}