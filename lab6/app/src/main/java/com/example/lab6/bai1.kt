package com.example.lab6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.lab6.ui.theme.Lab6Theme
import androidx.compose.ui.graphics.Color

class bai1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab6Theme {
                MovieScreen1(Movie_bai1.getSampleMovies())
            }
        }
    }
}

data class Movie_bai1(
    val title: String,
    val year: String,
    val posterUrl: String
) {
    companion object {
        fun getSampleMovies() = listOf(
            Movie_bai1("Mắt Biếc", "2019", "https://tse2.mm.bing.net/th?id=OIP.SDaqWnDlb2OLp4uMDjn5bAHaKl&pid=Api&P=0&h=180"),
            Movie_bai1("Hành tinh cát - Phần 2", "2024",    "https://upload.wikimedia.org/wikipedia/vi/9/94/Dune_2_VN_poster.jpg",),
            Movie_bai1(  "Kang Fu Panda 4", "2024",
                "https://lh4.googleusercontent.com/proxy/0ANH87_RsjcPVN_BPzv_LHYVYwO44rC9-yozjnYZUF2iqF36uvUJgSStqQuTfmcYHgtToTu7vXdqirFhitZH_XP36KbyZ-_qgxI87CX_Md0sg0Lt",
            )
        )
    }
}

@Composable
fun MovieItem(movie: Movie_bai1) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
    ) {
        Column(
            modifier = Modifier
                .width(175.dp)
                .height(330.dp)
        ) {
            AsyncImage(
                model = movie.posterUrl,
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .height(255.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp)),
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 2
                )
                Text(
                    text = "Thời lượng: ${movie.year}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
fun MovieScreen1(movies: List<Movie_bai1>) {
    LazyRow(
        state = rememberLazyListState(),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movies.size) { index ->
            MovieItem(movie = movies[index])
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreviewbai1() {
    Lab6Theme {
        MovieScreen1(Movie_bai1.getSampleMovies())
    }
}
