package com.bascencio.parcialmoviles

import android.app.Application
import com.bascencio.parcialmoviles.data.movies
import com.bascencio.parcialmoviles.repositories.MovieRepository

class MovieReviewerApplication: Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}