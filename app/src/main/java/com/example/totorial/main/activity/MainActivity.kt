package com.example.totorial.main.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.totorial.MainApplication
import com.example.totorial.R
import com.example.totorial.dagger.SmartPhone
import com.example.totorial.databinding.ActivityMainBinding
import javax.inject.Inject
import com.example.totorial.main.data.Studen as Studen

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var smartPhone: SmartPhone

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialVariable()

        (application as MainApplication).smartPhoneComponent
            .inject(this)
        smartPhone.makeACallWithRecording()
    }

    private fun initialVariable() {

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

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

            button3.setOnClickListener{
                textView.visibility = View.INVISIBLE
            }
            student = Studen(1,"Tanachat", "tanachart.ar@gmail.com")
        }
    }
}