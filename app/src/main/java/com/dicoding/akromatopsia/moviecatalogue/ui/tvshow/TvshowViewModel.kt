package com.dicoding.akromatopsia.moviecatalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import com.dicoding.akromatopsia.moviecatalogue.data.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.utils.DataDummy

class TvshowViewModel : ViewModel() {

    fun getTvshows(): List<TvshowEntity> = DataDummy.generateDummyTvshow()

}