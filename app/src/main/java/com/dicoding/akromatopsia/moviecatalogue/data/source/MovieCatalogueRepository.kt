package com.dicoding.akromatopsia.moviecatalogue.data.source

import com.dicoding.akromatopsia.moviecatalogue.data.MovieEntity
import com.dicoding.akromatopsia.moviecatalogue.data.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.remote.RemoteDataSource

class MovieCatalogueRepository private constructor(private val remoteDataSource: RemoteDataSource) : MovieCatalogueDataSource {

    companion object {
        @Volatile
        private var instance: MovieCatalogueRepository? = null
        fun getInstance(remoteData: RemoteDataSource): MovieCatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: MovieCatalogueRepository(remoteData)
            }
    }

    override fun getAllMovies(): List<MovieEntity> {
        val movieResponses = remoteDataSource.getAllMovies()
        val movieList = ArrayList<MovieEntity>()
        for (response in movieResponses) {
            val movie = MovieEntity(
                response.movieId,
                response.title,
                response.year,
                response.releaseDate,
                response.genres,
                response.duration,
                response.description,
                response.poster)
            movieList.add(movie)
        }
        return movieList
    }

    override fun getAllTvshows(): List<TvshowEntity> {
        val tvshowResponses = remoteDataSource.getAllTvshows()
        val tvshowList = ArrayList<TvshowEntity>()
        for (response in tvshowResponses) {
            val tvshow = TvshowEntity(
                response.movieId,
                response.title,
                response.year,
                response.genres,
                response.duration,
                response.description,
                response.poster)
            tvshowList.add(tvshow)
        }
        return tvshowList
    }

}