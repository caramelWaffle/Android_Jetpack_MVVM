package com.example.totorial.view_model_live_data.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.totorial.databinding.FragmentViewModelChallengeBinding
import com.example.totorial.view_model_live_data.view_model.ChallengeActivityViewModel
import com.example.totorial.view_model_live_data.view_model.ViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


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