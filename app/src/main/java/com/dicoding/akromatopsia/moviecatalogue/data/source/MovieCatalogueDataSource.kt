package com.dicoding.akromatopsia.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.dicoding.akromatopsia.moviecatalogue.data.MovieEntity
import com.dicoding.akromatopsia.moviecatalogue.data.TvshowEntity

interface MovieCatalogueDataSource {

    fun getAllMovies(): LiveData<List<MovieEntity>>

    fun getAllTvshows(): LiveData<List<TvshowEntity>>

}