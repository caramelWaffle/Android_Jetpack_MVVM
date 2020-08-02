package com.example.totorial.twoway_binding.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.totorial.R
import com.example.totorial.databinding.FragmentTwowayBindingBinding
import com.example.totorial.databinding.FragmentViewModelChallengeBinding
import com.example.totorial.twoway_binding.view_model.TwoWayViewModel
import com.example.totorial.twoway_binding.view_model.TwoWayViewModelFactory


class TwoWayBindingFragment : Fragment() {
    private lateinit var binding: FragmentTwowayBindingBinding
    private lateinit var viewModel: TwoWayViewModel
    private lateinit var factory: TwoWayViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwowayBindingBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        init(savedInstanceState)
        return binding.root
    }

    private fun init(savedInstanceState: Bundle?) {
        factory = TwoWayViewModelFactory("Chart")
        viewModel = ViewModelProvider(this, factory).get(TwoWayViewModel::class.java)
        binding.mViewModel = viewModel
        binding.lifecycleOwner = this

    }



    companion object {
        fun newInstance(): TwoWayBindingFragment {
            val fragment = TwoWayBindingFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}