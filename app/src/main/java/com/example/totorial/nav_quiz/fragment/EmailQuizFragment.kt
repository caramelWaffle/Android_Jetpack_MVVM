package com.example.totorial.nav_quiz.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.totorial.R
import com.example.totorial.databinding.FragmentEmailQuizBinding


class EmailQuizFragment : Fragment() {
    private lateinit var binding: FragmentEmailQuizBinding
    private lateinit var userName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userName = it.getString("user_name")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEmailQuizBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        initInstances()
        return binding.root
    }

    private fun initInstances() {
        binding.apply {
            btnSubmit.setOnClickListener {
                val bundle = bundleOf("user_name" to userName, "user_email" to edtEmail.text.toString())
                it.apply {
                    findNavController().navigate(R.id.action_emailQuizFragment_to_welcomeFragment, bundle)
//                    findNavController().popBackStack(R.id.nameQuizFragment, true)
//                    findNavController().popBackStack(R.id.homeQuizFragment, true)

                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EmailQuizFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}