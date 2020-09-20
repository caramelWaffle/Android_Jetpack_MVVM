package com.example.totorial.demo.presenter.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.totorial.databinding.FragmentMovieBinding
import com.example.totorial.demo.presenter.di.Injector
import com.example.totorial.demo.presenter.viewmodel.MovieViewModel
import com.example.totorial.demo.presenter.viewmodel.MovieViewModelFactory

import javax.inject.Inject

class MovieFragment : Fragment() {
    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: FragmentMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        initialize()
        return binding.root
    }

    private fun initialize() {
        (requireActivity().applicationContext as Injector).createMovieSubComponent().inject(this)
        movieViewModel = ViewModelProvider(this, movieViewModelFactory).get(MovieViewModel::class.java)
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(requireActivity(), Observer {
            Log.i("myTag", it.toString())
        })
    }
    companion object {
        @JvmStatic
        fun newInstance() =  MovieFragment()
    }
}