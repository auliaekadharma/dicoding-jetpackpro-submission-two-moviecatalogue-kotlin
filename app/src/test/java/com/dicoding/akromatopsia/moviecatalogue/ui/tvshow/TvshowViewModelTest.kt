package com.dicoding.akromatopsia.moviecatalogue.ui.tvshow

import com.dicoding.akromatopsia.moviecatalogue.data.MovieEntity
import com.dicoding.akromatopsia.moviecatalogue.data.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.MovieCatalogueRepository
import com.dicoding.akromatopsia.moviecatalogue.utils.DataDummy
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvshowViewModelTest {

    private lateinit var viewModel: TvshowViewModel

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Before
    fun setUp() {
        viewModel = TvshowViewModel(movieCatalogueRepository)
    }

    @Test
    fun getTvshows() {
        Mockito.`when`<List<TvshowEntity>>(movieCatalogueRepository.getAllTvshows()).thenReturn(
            DataDummy.generateDummyTvshow())
        val tvshowEntities = viewModel.getTvshows()
        Assert.assertNotNull(tvshowEntities)
        Assert.assertEquals(10, tvshowEntities.size)
    }
}