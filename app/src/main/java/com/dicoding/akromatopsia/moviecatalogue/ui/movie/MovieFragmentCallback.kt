package com.dicoding.akromatopsia.moviecatalogue.ui.movie

import com.dicoding.akromatopsia.moviecatalogue.data.MovieEntity

interface MovieFragmentCallback {
    fun onShareClick(movie: MovieEntity)
}
