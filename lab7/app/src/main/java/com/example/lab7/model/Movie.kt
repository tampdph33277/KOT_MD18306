package com.example.lab7

import com.example.lab7.model.MovieResponse


data class Movie(
    val id: String,
    val title: String,
    val releaseDate: String,
    val posterUrl: String,
    val shortDescription: String,
    val genre: String,
    val duration: String
)



fun MovieResponse.toMovie(): Movie {
    return Movie(
        id = this.filmId,
        title = this.filmName,
        duration = this.duration,
        releaseDate = this.releaseDate,
        genre = this.genre,
        shortDescription = this.description,
        posterUrl = this.image
    )
}
