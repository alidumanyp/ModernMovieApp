package com.aliduman.movieappmodern.domain.use_case.get_movie_detail

import com.aliduman.movieappmodern.data.remote.dto.toMovieDetail
import com.aliduman.movieappmodern.domain.model.MovieDetail
import com.aliduman.movieappmodern.domain.repository.MovieRepository
import com.aliduman.movieappmodern.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repository: MovieRepository) {

    fun executeGetMovieDetails(imdbId: String) : Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetail = repository.getMovieDetail(imdbId)
            emit(Resource.Success(movieDetail.toMovieDetail()))
        } catch (e: IOError) {
            emit(Resource.Error("No internet connection"))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Error"))
        }
    }


}