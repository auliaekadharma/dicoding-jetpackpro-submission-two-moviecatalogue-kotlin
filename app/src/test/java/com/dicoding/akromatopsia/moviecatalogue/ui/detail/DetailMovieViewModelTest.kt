package com.dicoding.akromatopsia.moviecatalogue.ui.detail

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
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.movieId

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(movieCatalogueRepository)
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getMovie() {
       `when`(movieCatalogueRepository.getAllMovies()).thenReturn(listOf(dummyMovie))
        viewModel.setSelectedMovie(dummyMovie.movieId)
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.movieId, movieEntity.movieId)
        assertEquals(dummyMovie.year, movieEntity.year)
        assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(dummyMovie.genres, movieEntity.genres)
        assertEquals(dummyMovie.duration, movieEntity.duration)
        assertEquals(dummyMovie.description, movieEntity.description)
        assertEquals(dummyMovie.poster, movieEntity.poster)
        assertEquals(dummyMovie.title, movieEntity.title)
    }
}