package com.aliduman.movieappmodern.presentation.movies

sealed class MoviesEvent {

    data class Search(val searchString : String) : MoviesEvent()
}