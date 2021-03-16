package com.dicoding.akromatopsia.moviecatalogue.ui.tvshow

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TvshowViewModelTest {

    private lateinit var viewModel: TvshowViewModel

    @Before
    fun setUp() {
        viewModel = TvshowViewModel()
    }

    @Test
    fun getTvshows() {
        val tvshowEntities = viewModel.getTvshows()
        Assert.assertNotNull(tvshowEntities)
        Assert.assertEquals(10, tvshowEntities.size)
    }
}