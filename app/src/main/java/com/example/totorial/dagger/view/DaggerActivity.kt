package com.example.totorial.dagger.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.totorial.R
import com.example.totorial.dagger.DaggerSmartPhoneComponent
import com.example.totorial.dagger.SmartPhone

class DaggerActivity : AppCompatActivity() {

    private lateinit var smartPhone: SmartPhone

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger)

        DaggerSmartPhoneComponent
            .create()
            .getSmartPhone()
    }
}