package com.dicoding.akromatopsia.moviecatalogue.data.source

import com.dicoding.akromatopsia.moviecatalogue.data.source.remote.RemoteDataSource
import com.dicoding.akromatopsia.moviecatalogue.data.source.remote.response.MovieResponse
import com.dicoding.akromatopsia.moviecatalogue.data.source.remote.response.TvshowResponse
import com.dicoding.akromatopsia.moviecatalogue.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

class MovieCatalogueRepositoryTest {

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val movieCatalogueRepository = FakeMovieCatalogueRepository(remote)

    private val movieResponses = DataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponses[0].movieId
    private val tvshowResponses = DataDummy.generateRemoteDummyTvshow()
    private val tvshowId = tvshowResponses[0].tvshowId

    @Test
    fun getAllMovies() {
        `when`<List<MovieResponse>>(remote.getAllMovies()).thenReturn(movieResponses)
        val movieEntities = movieCatalogueRepository.getAllMovies()
        verify<RemoteDataSource>(remote).getAllMovies()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getAllTvshows() {
        `when`<List<TvshowResponse>>(remote.getAllTvshows()).thenReturn(tvshowResponses)
        val tvshowEntities = movieCatalogueRepository.getAllTvshows()
        verify<RemoteDataSource>(remote).getAllTvshows()
        assertNotNull(tvshowEntities)
        assertEquals(tvshowResponses.size.toLong(), tvshowEntities.size.toLong())
    }
}