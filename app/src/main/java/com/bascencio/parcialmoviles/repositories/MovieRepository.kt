package com.bascencio.parcialmoviles.repositories

import com.bascencio.parcialmoviles.data.model.MovieModel
import com.bascencio.parcialmoviles.data.movies

class MovieRepository(private val repository: MutableList<MovieModel>) {

    fun getMovies() = movies

    fun addMovies(movie: MovieModel) = movies.add(movie)
}