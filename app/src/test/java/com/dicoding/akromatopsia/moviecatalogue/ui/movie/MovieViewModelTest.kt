package com.dicoding.akromatopsia.moviecatalogue.ui.movie

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        viewModel = MovieViewModel()
    }

    @Test
    fun getMovies() {
        val movieEntities = viewModel.getMovies()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities.size)
    }
}