package com.example.lab7

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab7.model.RetrofitService
import kotlinx.coroutines.launch
class MovieViewModel : ViewModel() {
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies

    init {
        getMovies()
    }

    fun getMovies() {
        viewModelScope.launch {
            val movieService = RetrofitService().movieService
            val response = movieService.getListFilms()
            if (response.isSuccessful) {
                _movies.postValue(response.body()?.map { it.toMovie() } ?: emptyList())
            } else {
                // Xử lý lỗi
            }
        }
    }

    fun addOrUpdateMovie(movie: Movie) {
        val currentList = _movies.value.orEmpty().toMutableList()
        val index = currentList.indexOfFirst { it.id == movie.id }
        if (index >= 0) {
            currentList[index] = movie
        } else {
            currentList.add(movie)
        }
        _movies.value = currentList
    }
    fun deleteMovie(movie: Movie) {
        _movies.value = _movies.value?.filterNot { it.id == movie.id }
        // Call the delete API endpoint if needed
        // Example:
        // viewModelScope.launch {
        //     movieService.deleteMovie(movie.id)
        // }
    }
}
