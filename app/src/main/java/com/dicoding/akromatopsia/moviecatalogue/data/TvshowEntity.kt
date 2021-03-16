package com.dicoding.akromatopsia.moviecatalogue.data

data class TvshowEntity(
    var tvshowId: String,
    var title: String,
    var year: String,
    var genres: String,
    var duration: String,
    var description: String,
    var poster: Int,
)
