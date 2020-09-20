package com.example.totorial.coroutine.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.totorial.R
import com.example.totorial.coroutine.viewmodel.CoroutineViewModel
import com.example.totorial.databinding.ActivityCoroutineBinding

class CoroutineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoroutineBinding
    private lateinit var viewModel: CoroutineViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(CoroutineViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_coroutine)
        binding.lifecycleOwner = this
        binding.apply {
            mViewModel = viewModel
        }
    }

}
