package com.example.lab7.model

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab7.Movie
import java.util.UUID

@Composable
fun EditMovieScreen(
    movie: Movie?,
    onSave: (Movie) -> Unit,
    onCancel: () -> Unit
) {
    var title by remember { mutableStateOf(movie?.title ?: "") }
    var releaseDate by remember { mutableStateOf(movie?.releaseDate ?: "") }
    var posterUrl by remember { mutableStateOf(movie?.posterUrl ?: "") }
    var shortDescription by remember { mutableStateOf(movie?.shortDescription ?: "") }
    var genre by remember { mutableStateOf(movie?.genre ?: "") }
    var duration by remember { mutableStateOf(movie?.duration ?: "") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = title, onValueChange = { title = it }, label = { Text("Title") })
        TextField(value = releaseDate, onValueChange = { releaseDate = it }, label = { Text("Release Date") })
        TextField(value = posterUrl, onValueChange = { posterUrl = it }, label = { Text("Poster URL") })
        TextField(value = shortDescription, onValueChange = { shortDescription = it }, label = { Text("Short Description") })
        TextField(value = genre, onValueChange = { genre = it }, label = { Text("Genre") })
        TextField(value = duration, onValueChange = { duration = it }, label = { Text("Duration") })
        Row {
            Button(onClick = { onCancel() }, modifier = Modifier.weight(1f)) { Text("Cancel") }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    val newMovie = Movie(
                        id = movie?.id ?: UUID.randomUUID().toString(),
                        title = title,
                        releaseDate = releaseDate,
                        posterUrl = posterUrl,
                        shortDescription = shortDescription,
                        genre = genre,
                        duration = duration
                    )
                    onSave(newMovie)
                },
                modifier = Modifier.weight(1f)
            ) { Text("Save") }
        }
    }
}
