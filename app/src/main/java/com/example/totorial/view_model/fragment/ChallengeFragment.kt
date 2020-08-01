package com.example.totorial.view_model.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.totorial.R
import com.example.totorial.databinding.FragmentViewModelChallengeBinding
import com.example.totorial.view_model.view_model.ChallengeActivityViewModel


class ChallengeFragment : Fragment() {
    lateinit var binding: FragmentViewModelChallengeBinding
    lateinit var viewModel: ChallengeActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?.let { onRestoreInstanceState(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewModelChallengeBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(ChallengeActivityViewModel::class.java)
        init(savedInstanceState)
        return binding.root
    }

    private fun init(savedInstanceState: Bundle?) {
        binding.apply {
            tvSum.text = viewModel.getScore().toString()
            btnSum.setOnClickListener {
                viewModel.sumScore(editTextNumber.text.toString())
                tvSum.text = viewModel.getScore().toString()
                editTextNumber.text.clear()
            }
        }
    }


    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    /*
     * Save Instance State Here
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    private fun onRestoreInstanceState(savedInstanceState: Bundle) {
        // Restore Instance State here
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