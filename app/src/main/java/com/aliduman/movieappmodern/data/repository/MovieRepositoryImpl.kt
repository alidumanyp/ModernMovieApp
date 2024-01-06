package com.aliduman.movieappmodern.data.repository

import com.aliduman.movieappmodern.data.remote.MovieAPI
import com.aliduman.movieappmodern.data.remote.dto.MovieDetailDto
import com.aliduman.movieappmodern.data.remote.dto.MoviesDto
import com.aliduman.movieappmodern.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api: MovieAPI) : MovieRepository {
    override suspend fun getMovies(search: String): MoviesDto {
        return api.getMovies(search)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {
        return api.getMovieDetail(imdbId)
    }

}
