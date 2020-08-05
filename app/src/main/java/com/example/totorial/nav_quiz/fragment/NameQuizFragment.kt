package com.example.totorial.nav_quiz.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.totorial.R
import com.example.totorial.databinding.FragmentNameQuizBinding
import com.example.totorial.nav_quiz.viewmodel.NavQuizViewModel
import com.example.totorial.nav_quiz.viewmodel.NavQuizViewModelFactory


class NameQuizFragment : Fragment() {
    private lateinit var binding: FragmentNameQuizBinding
    private lateinit var factory: NavQuizViewModelFactory
    private lateinit var viewModel: NavQuizViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNameQuizBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        initInstances()
        return binding.root
    }

    private fun initInstances() {
        factory = NavQuizViewModelFactory("Username")
        viewModel = ViewModelProvider(this, factory).get(NavQuizViewModel::class.java)
        binding.mViewModel = viewModel
        binding.apply {
            edtYear.setOnEditorActionListener { textView, actionID, keyEvent ->
                if(actionID == EditorInfo.IME_ACTION_DONE){
                    mViewModel?.getBirthYear()
                    return@setOnEditorActionListener true
                }
                false
            }

            btnNameSubmit.setOnClickListener{
                val bundle = bundleOf("user_name" to this.edtName.text.toString())
                it.findNavController().navigate(R.id.action_nameQuizFragment_to_emailQuizFragment, bundle)
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NameQuizFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}