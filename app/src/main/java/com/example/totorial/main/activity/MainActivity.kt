package com.example.totorial.main.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.totorial.R
import com.example.totorial.databinding.ActivityMainBinding
import com.example.totorial.main.data.Studen as Studen

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialVariable()
    }

    private fun initialVariable() {

        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )

        binding.apply {
            button.setOnClickListener {
                if (progressBar.visibility == View.GONE){
                    button.text = "STOP"
                    progressBar.visibility = View.VISIBLE
                }else{
                    button.text = "START"
                    progressBar.visibility = View.GONE
                }
            }

            button2.setOnClickListener{
                textView.visibility = View.VISIBLE
            }

            student = Studen(1,"Tanachat", "tanachart.ar@gmail.com")
        }
    }
}