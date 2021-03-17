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
class DetailTvshowViewModelTest {

    private lateinit var viewModel: DetailTvshowViewModel
    private val dummyTvshow = DataDummy.generateDummyTvshow()[0]
    private val tvshowId = dummyTvshow.tvshowId

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Before
    fun setUp() {
        viewModel = DetailTvshowViewModel(movieCatalogueRepository)
        viewModel.setSelectedTvshow(tvshowId)
    }


    @Test
    fun getTvshow() {
        `when`(movieCatalogueRepository.getAllTvshows()).thenReturn(listOf(dummyTvshow))
        viewModel.setSelectedTvshow(dummyTvshow.tvshowId)
        val tvshowEntity = viewModel.getTvshow()
        assertNotNull(tvshowEntity)
        assertEquals(dummyTvshow.tvshowId, tvshowEntity.tvshowId)
        assertEquals(dummyTvshow.year, tvshowEntity.year)
        assertEquals(dummyTvshow.genres, tvshowEntity.genres)
        assertEquals(dummyTvshow.duration, tvshowEntity.duration)
        assertEquals(dummyTvshow.description, tvshowEntity.description)
        assertEquals(dummyTvshow.poster, tvshowEntity.poster)
        assertEquals(dummyTvshow.title, tvshowEntity.title)
    }
}