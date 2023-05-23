package com.bascencio.parcialmoviles.ui.movie.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.bascencio.parcialmoviles.data.model.MovieModel
import com.bascencio.parcialmoviles.databinding.MovieItemBinding

class MovieRecyclerViewHolder(private val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: MovieModel, clickListener: (MovieModel)->Unit){
        binding.textTitle.text = movie.title
        binding.textDirector.text = movie.director

        binding.movieItemCardView.setOnClickListener{
            clickListener(movie)
        }
    }
}