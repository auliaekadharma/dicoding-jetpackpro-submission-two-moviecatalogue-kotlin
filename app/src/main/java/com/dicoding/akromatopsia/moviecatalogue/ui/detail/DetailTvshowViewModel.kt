package com.dicoding.akromatopsia.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.akromatopsia.moviecatalogue.data.MovieEntity
import com.dicoding.akromatopsia.moviecatalogue.data.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.MovieCatalogueRepository
import com.dicoding.akromatopsia.moviecatalogue.utils.DataDummy

class DetailTvshowViewModel (private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {
    private lateinit var tvshowId: String

    fun setSelectedTvshow(tvshowId: String) {
        this.tvshowId = tvshowId
    }

//    fun getTvshow(): TvshowEntity {
//        lateinit var tvshow: TvshowEntity
//        val tvshowsEntities = movieCatalogueRepository.getAllTvshows()
//        for (tvshowEntity in tvshowsEntities) {
//            if (tvshowEntity.tvshowId == tvshowId) {
//                tvshow = tvshowEntity
//            }
//        }
//        return tvshow
//    }

    fun getTvshow() : LiveData<List<TvshowEntity>> = movieCatalogueRepository.getAllTvshows()
}