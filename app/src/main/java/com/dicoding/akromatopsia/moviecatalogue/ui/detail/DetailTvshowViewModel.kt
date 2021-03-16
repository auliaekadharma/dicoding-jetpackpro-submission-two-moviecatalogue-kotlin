package com.dicoding.akromatopsia.moviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.dicoding.akromatopsia.moviecatalogue.data.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.utils.DataDummy

class DetailTvshowViewModel : ViewModel() {
    private lateinit var tvshowId: String

    fun setSelectedTvshow(tvshowId: String) {
        this.tvshowId = tvshowId
    }

    fun getTvshow(): TvshowEntity {
        lateinit var tvshow: TvshowEntity
        val tvshowsEntities = DataDummy.generateDummyTvshow()
        for (tvshowEntity in tvshowsEntities) {
            if (tvshowEntity.tvshowId == tvshowId) {
                tvshow = tvshowEntity
            }
        }
        return tvshow
    }
}