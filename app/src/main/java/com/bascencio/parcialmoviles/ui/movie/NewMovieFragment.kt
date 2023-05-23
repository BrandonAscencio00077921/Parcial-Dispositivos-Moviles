package com.bascencio.parcialmoviles.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import com.bascencio.parcialmoviles.R
import com.bascencio.parcialmoviles.databinding.FragmentNewMovieBinding


class NewMovieFragment : Fragment() {

    private lateinit var Name : EditText
    private lateinit var Category: EditText
    private lateinit var Description: EditText
    private lateinit var Qualification: EditText
    private lateinit var Submit: Button

    private lateinit var binding: FragmentNewMovieBinding
    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewMovieBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
    }

    private fun setViewModel() {
        binding.viewmodel = movieViewModel
    }
}