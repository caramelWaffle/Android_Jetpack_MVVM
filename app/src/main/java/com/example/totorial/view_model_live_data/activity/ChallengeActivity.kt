package com.example.totorial.view_model_live_data.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.totorial.R
import com.example.totorial.databinding.ActivityViewModelChallengeBinding
import com.example.totorial.view_model_live_data.fragment.ChallengeFragment

class ChallengeActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewModelChallengeBinding
    lateinit var fragment: ChallengeFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Challenge View Model "
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_model_challenge)
        fragment = ChallengeFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.container, fragment).commit()
    }
}