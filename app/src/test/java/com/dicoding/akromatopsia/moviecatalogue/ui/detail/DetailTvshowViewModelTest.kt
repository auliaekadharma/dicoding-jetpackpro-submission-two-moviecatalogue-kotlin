package com.dicoding.akromatopsia.moviecatalogue.ui.detail

import com.dicoding.akromatopsia.moviecatalogue.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailTvshowViewModelTest {

    private lateinit var viewModel: DetailTvshowViewModel
    private val dummyTvshow = DataDummy.generateDummyTvshow()[0]
    private val tvshowId = dummyTvshow.tvshowId

    @Before
    fun setUp() {
        viewModel = DetailTvshowViewModel()
        viewModel.setSelectedTvshow(tvshowId)
    }


    @Test
    fun getTvshow() {
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