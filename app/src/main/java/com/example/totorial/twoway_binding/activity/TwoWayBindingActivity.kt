package com.example.totorial.twoway_binding.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.totorial.R
import com.example.totorial.twoway_binding.fragment.TwoWayBindingFragment

class TwoWayBindingActivity : AppCompatActivity() {
    private lateinit var fragment: TwoWayBindingFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_way_binding)
        fragment = TwoWayBindingFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.container, fragment).commit()
        supportActionBar?.title = "Two Way Binding"
    }
}