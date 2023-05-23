package com.bascencio.parcialmoviles.ui.movie.billboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bascencio.parcialmoviles.R
import com.bascencio.parcialmoviles.data.model.MovieModel
import com.bascencio.parcialmoviles.databinding.FragmentBillboardBinding
import com.bascencio.parcialmoviles.ui.movie.MovieViewModel
import com.bascencio.parcialmoviles.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter

class BillboardFragment : Fragment() {

    private lateinit var adapter: MovieRecyclerViewAdapter
    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var binding: FragmentBillboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBillboardBinding.inflate(inflater, container, false)
        return binding.root
      }
    private fun showSelectedItem(movie: MovieModel) {
        movieViewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
    }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            setReclyclerView(view)

            binding.buttonAdd.setOnClickListener {
                movieViewModel.clearData()
                it.findNavController().navigate(R.id.action_billboardFragment_to_newMovieFragment)
            }
        }

            private fun displayMovies() {
                adapter.setData(movieViewModel.getMovies())
                adapter.notifyDataSetChanged()
            }

            private fun setReclyclerView(view: View) {
                binding.recyclerViewMovie.layoutManager = LinearLayoutManager(view.context)

                adapter = MovieRecyclerViewAdapter { selectedMovie ->
                    showSelectedItem(selectedMovie)
                }
                binding.recyclerViewMovie.adapter = adapter
                displayMovies()
            }
        }
