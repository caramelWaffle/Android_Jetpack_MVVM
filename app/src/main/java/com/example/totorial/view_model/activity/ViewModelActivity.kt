package com.example.totorial.view_model.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
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
        binding.apply {
            tvCounter.text = viewModel.getCounter().toString()
            btnCounter.setOnClickListener{
                viewModel.updateCounter()
                tvCounter.text = viewModel.getCounter().toString()
            }
        }
    }

}