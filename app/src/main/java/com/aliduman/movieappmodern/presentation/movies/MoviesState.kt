package com.aliduman.movieappmodern.presentation.movies

import com.aliduman.movieappmodern.domain.model.Movie

data class MoviesState(
    val isLoading : Boolean = false,
    val movies : List<Movie> = emptyList(),
    val error : String = "",
    val search : String = "batman"
)