package com.example.totorial.nav.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.totorial.R
import com.example.totorial.databinding.ActivityNavBinding

class NavActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_nav)
        supportActionBar?.title = "Navigation"
    }
}