package com.example.totorial.view_model.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.totorial.R
import com.example.totorial.databinding.FragmentViewModelChallengeBinding
import com.example.totorial.view_model.view_model.ChallengeActivityViewModel
import com.example.totorial.view_model.view_model.ViewModelFactory


class ChallengeFragment : Fragment() {
    lateinit var binding: FragmentViewModelChallengeBinding
    lateinit var viewModel: ChallengeActivityViewModel
    lateinit var viewModelFactory: ViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewModelChallengeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        init(savedInstanceState)
        return binding.root
    }

    private fun init(savedInstanceState: Bundle?) {
        viewModelFactory = ViewModelFactory(10)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ChallengeActivityViewModel::class.java)
        binding.mViewModel = viewModel
    }

    companion object {
        fun newInstance(): ChallengeFragment {
            val fragment = ChallengeFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}