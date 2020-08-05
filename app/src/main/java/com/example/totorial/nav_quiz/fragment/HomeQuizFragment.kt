package com.example.totorial.nav_quiz.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.totorial.R
import com.example.totorial.databinding.FragmentHomeQuizBinding

class HomeQuizFragment : Fragment() {
    private lateinit var binding : FragmentHomeQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeQuizBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        setInstances()
        return binding.root
    }

    private fun setInstances() {
        binding.apply {
            this.btnTerm.setOnClickListener {
                it.findNavController().navigate(R.id.action_homeQuizFragment_to_termQuizFragment)
            }
            this.btnSignUp.setOnClickListener {
                it.findNavController().navigate(R.id.action_homeQuizFragment_to_nameQuizFragment)
            }
        }
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            HomeQuizFragment().apply {

            }
    }
}
