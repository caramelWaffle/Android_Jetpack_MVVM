package com.example.totorial.dagger.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.totorial.MainApplication
import com.example.totorial.R
import com.example.totorial.dagger.DaggerSmartPhoneComponent
import com.example.totorial.dagger.SmartPhone
import javax.inject.Inject

class DaggerActivity : AppCompatActivity() {

    @Inject
    lateinit var smartPhone: SmartPhone

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger)

        (application as MainApplication).smartPhoneComponent
            .inject(this)

        smartPhone.makeACallWithRecording()
    }
}