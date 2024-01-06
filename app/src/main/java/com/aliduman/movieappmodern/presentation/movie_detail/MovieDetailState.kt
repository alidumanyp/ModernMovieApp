package com.aliduman.movieappmodern.presentation.movie_detail

import com.aliduman.movieappmodern.domain.model.MovieDetail

data class MovieDetailState (
    val isLoading : Boolean = false,
    val movie :  MovieDetail? = null,
    val error : String = ""
)