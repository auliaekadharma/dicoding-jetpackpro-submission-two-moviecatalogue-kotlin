package com.dicoding.akromatopsia.moviecatalogue.ui.tvshow

import com.dicoding.akromatopsia.moviecatalogue.data.TvshowEntity

interface TvshowFragmentCallback {
    fun onShareClick(tvshow: TvshowEntity)
}
