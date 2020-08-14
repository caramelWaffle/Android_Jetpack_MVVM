package com.example.totorial.nav_quiz.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.totorial.R
import com.example.totorial.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding
    private lateinit var userName: String
    private lateinit var userEmail: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userName = it.getString("user_name")!!
            userEmail = it.getString("user_email")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        initInstances()
        return binding.root
    }

    private fun initInstances() {
        binding.apply {
            tvName.text = userName
//            .text = userEmail
            btnTerm.setOnClickListener {
                it.findNavController().navigate(R.id.action_welcomeFragment_to_termQuizFragment)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WelcomeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}