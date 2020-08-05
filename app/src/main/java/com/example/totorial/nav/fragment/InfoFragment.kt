package com.example.totorial.nav.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.totorial.R
import com.example.totorial.databinding.FragmentInfoBinding


class InfoFragment : Fragment() {
    private lateinit var binding : FragmentInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar?.title = "Info Fragment"
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        initialize()
        return binding.root
    }

    private fun initialize() {
        val userInput = arguments?.getString("user_input")
        val fml = arguments?.getString("fml")
        val text = userInput + fml
        binding.userInput.text = text
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InfoFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}