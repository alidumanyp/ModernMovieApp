package com.aliduman.movieappmodern.domain.use_case.get_movies

import com.aliduman.movieappmodern.data.remote.dto.toMovieList
import com.aliduman.movieappmodern.domain.model.Movie
import com.aliduman.movieappmodern.domain.repository.MovieRepository
import com.aliduman.movieappmodern.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository: MovieRepository) {

    fun executeGetMovies(search: String) : Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movieList = repository.getMovies(search)

            if (movieList.Response == "True") {
                emit(Resource.Success(movieList.toMovieList()))
            } else {
                emit(Resource.Error("No movie found!"))
            }

        } catch (e: IOError) {
            emit(Resource.Error("No internet connection"))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Error"))
        }

    }


}