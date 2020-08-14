package com.example.totorial.room.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.totorial.databinding.FragmentRoomBinding
import com.example.totorial.room.data.User
import com.example.totorial.room.data.UserDatabase
import com.example.totorial.room.data.source.UserRepository
import com.example.totorial.room.view.adapter.RoomAdapter
import com.example.totorial.room.viewmodel.RoomViewModel
import com.example.totorial.room.viewmodel.RoomViewModelFactory


class RoomFragment : Fragment() {
    private lateinit var binding: FragmentRoomBinding
    private lateinit var viewModelFactory: RoomViewModelFactory
    private lateinit var viewModel: RoomViewModel
    private lateinit var adapter: RoomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRoomBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        initializeInstance(savedInstanceState)
        return binding.root
    }

    private fun initializeInstance(savedInstanceState: Bundle?) {
        val userDAO = UserDatabase.getInstance(requireActivity().application).userDAO
        val userRepository = UserRepository(userDAO)
        viewModelFactory = RoomViewModelFactory(userRepository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(RoomViewModel::class.java)
        binding.mViewModel = viewModel
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        adapter = RoomAdapter({ seletedItem: User -> onListItemClick(seletedItem) })
        binding.recyclerview.adapter = adapter
        observeData()
    }

    private fun observeData() {
        viewModel.users.observe(requireActivity(), Observer { user_list ->
            adapter.setData(user_list)
            binding.edtUsername.requestFocus()

        })

        viewModel.message.observe(requireActivity(), Observer { event ->
            event.getContentIfNotHandled()?.let { message ->
                Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun onListItemClick(user: User) {
        binding.edtUsername.requestFocus()
        Toast.makeText(requireContext(), user.name, Toast.LENGTH_SHORT).show()
        viewModel.initUpdateAndDelete(user)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RoomFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}