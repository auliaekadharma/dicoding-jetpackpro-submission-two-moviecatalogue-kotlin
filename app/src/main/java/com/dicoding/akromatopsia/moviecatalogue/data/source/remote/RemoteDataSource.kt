package com.dicoding.akromatopsia.moviecatalogue.data.source.remote

import android.os.Handler
import com.dicoding.akromatopsia.moviecatalogue.data.source.remote.response.MovieResponse
import com.dicoding.akromatopsia.moviecatalogue.data.source.remote.response.TvshowResponse
import com.dicoding.akromatopsia.moviecatalogue.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler()

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper)
            }
    }

    fun getAllMovies(callback: LoadMoviesCallback) {
        handler.postDelayed({ callback.onAllMoviesReceived(jsonHelper.loadMovies()) }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getAllTvshows(callback: LoadTvshowsCallback) {
        handler.postDelayed({ callback.onAllTvshowsReceived(jsonHelper.loadTvshows()) }, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(movieResponses: List<MovieResponse>)
    }

    interface LoadTvshowsCallback {
        fun onAllTvshowsReceived(tvshowResponses: List<TvshowResponse>)
    }
}