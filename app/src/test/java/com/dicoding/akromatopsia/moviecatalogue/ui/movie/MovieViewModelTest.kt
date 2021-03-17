package com.dicoding.akromatopsia.moviecatalogue.ui.movie

import com.dicoding.akromatopsia.moviecatalogue.data.MovieEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.MovieCatalogueRepository
import com.dicoding.akromatopsia.moviecatalogue.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Before
    fun setUp() {
        viewModel = MovieViewModel(movieCatalogueRepository)
    }

    @Test
    fun getMovies() {
        Mockito.`when`<List<MovieEntity>>(movieCatalogueRepository.getAllMovies()).thenReturn(DataDummy.generateDummyMovies())
        val movieEntities = viewModel.getMovies()
        verify(movieCatalogueRepository).getAllMovies()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities.size)
    }
}