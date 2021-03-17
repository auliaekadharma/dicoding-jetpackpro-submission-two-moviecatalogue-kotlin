package com.dicoding.akromatopsia.moviecatalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import com.dicoding.akromatopsia.moviecatalogue.data.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.MovieCatalogueRepository
import com.dicoding.akromatopsia.moviecatalogue.utils.DataDummy

class TvshowViewModel (private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getTvshows(): List<TvshowEntity> = movieCatalogueRepository.getAllTvshows()

}