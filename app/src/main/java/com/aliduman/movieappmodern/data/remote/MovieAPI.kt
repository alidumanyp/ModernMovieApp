package com.aliduman.movieappmodern.data.remote

import com.aliduman.movieappmodern.data.remote.dto.MovieDetailDto
import com.aliduman.movieappmodern.data.remote.dto.MoviesDto
import com.aliduman.movieappmodern.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {
    //https://www.omdbapi.com/?apikey=c64b90bd&s=batman
    //https://www.omdbapi.com/?apikey=c64b90bd&i=tt0372784

    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString : String,
        @Query("apikey") apiKey : String = API_KEY
    ) : MoviesDto

    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbId : String,
        @Query("apikey") apiKey : String = API_KEY

    ) : MovieDetailDto
}