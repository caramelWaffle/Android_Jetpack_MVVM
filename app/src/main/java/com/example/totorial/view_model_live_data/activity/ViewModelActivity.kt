package com.example.totorial.view_model_live_data.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.totorial.R
import com.example.totorial.databinding.ActivityViewModelBinding
import com.example.totorial.view_model_live_data.view_model.ViewModelActivityViewModel

class ViewModelActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewModelBinding
    private lateinit var viewModel: ViewModelActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_model)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this).get(ViewModelActivityViewModel::class.java)
        binding.mainViewModel = viewModel
    }

}