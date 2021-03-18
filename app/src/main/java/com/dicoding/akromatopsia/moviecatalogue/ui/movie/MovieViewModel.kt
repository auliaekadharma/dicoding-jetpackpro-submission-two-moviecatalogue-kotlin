package com.dicoding.akromatopsia.moviecatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.akromatopsia.moviecatalogue.data.MovieEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.MovieCatalogueRepository
import com.dicoding.akromatopsia.moviecatalogue.utils.DataDummy

class MovieViewModel (private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getMovies(): LiveData<List<MovieEntity>> = movieCatalogueRepository.getAllMovies()

}