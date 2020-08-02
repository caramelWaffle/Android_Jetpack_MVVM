package com.example.totorial.view_model.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.totorial.R
import com.example.totorial.databinding.ActivityViewModelBinding
import com.example.totorial.view_model.view_model.ViewModelActivityViewModel

class ViewModelActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewModelBinding
    private lateinit var viewModel: ViewModelActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_model)
        viewModel = ViewModelProvider(this).get(ViewModelActivityViewModel::class.java)
        viewModel.getCount().observe(this, Observer {
            binding.tvCounter.text = it.toString()
        })
        binding.apply {
            btnCounter.setOnClickListener{
                viewModel.increaseCount()
            }
        }
    }

}