package com.example.totorial.template

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.totorial.databinding.FragmentTwowayBindingBinding
import com.example.totorial.twoway_binding.view_model.TwoWayViewModel


class FragmentTemplateWithViewModel : Fragment() {
    private lateinit var binding: FragmentTwowayBindingBinding
    private lateinit var viewModel: TwoWayViewModel


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
        viewModel = ViewModelProvider(this).get(TwoWayViewModel::class.java)
        binding.mViewModel = viewModel
    }



    companion object {
        fun newInstance(): FragmentTemplateWithViewModel {
            val fragment = FragmentTemplateWithViewModel()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}