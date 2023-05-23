package com.bascencio.parcialmoviles.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bascencio.parcialmoviles.R
import com.bascencio.parcialmoviles.databinding.FragmentMovieBinding

class MovieFragment : Fragment() {

    private lateinit var binding : FragmentMovieBinding
    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
    }
    private fun setViewModel(){
        binding.viewmodel = movieViewModel
    }
}