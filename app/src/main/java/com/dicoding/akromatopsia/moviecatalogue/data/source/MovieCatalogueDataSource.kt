package com.dicoding.akromatopsia.moviecatalogue.data.source

import com.dicoding.akromatopsia.moviecatalogue.data.MovieEntity
import com.dicoding.akromatopsia.moviecatalogue.data.TvshowEntity

interface MovieCatalogueDataSource {

    fun getAllMovies(): List<MovieEntity>

    fun getAllTvshows(): List<TvshowEntity>

}