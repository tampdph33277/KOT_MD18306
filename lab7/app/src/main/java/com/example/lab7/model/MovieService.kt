package com.example.lab7.model

import retrofit2.Response
import retrofit2.http.GET

interface MovieService {
    @GET("api/Film")
    suspend fun getListFilms(): Response<List<MovieResponse>>
}