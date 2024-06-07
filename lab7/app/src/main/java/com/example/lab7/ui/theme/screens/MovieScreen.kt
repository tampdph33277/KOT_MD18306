package com.example.lab7

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.lab7.model.EditMovieScreen

enum class ListType {
    ROW, COLUMN, GRID
}

@Composable
fun Movie(value: List<Movie>, navController: NavHostController) {
    val movieViewModel: MovieViewModel = viewModel()
    val moviesState = movieViewModel.movies.observeAsState(initial = emptyList())
    fun handleDelete(movie: Movie) {
        movieViewModel.deleteMovie(movie)
    }

    MovieScreen( navController = navController, onDelete = ::handleDelete
    )
}

@Composable
fun MovieScreen(navController: NavController,onDelete: (Movie) -> Unit) {
    val movieViewModel: MovieViewModel = viewModel()
    val moviesState by movieViewModel.movies.observeAsState(initial = emptyList())
    var showEditScreen by remember { mutableStateOf(false) }
    var movieToEdit by remember { mutableStateOf<Movie?>(null) }

    if (showEditScreen) {
        EditMovieScreen(
            movie = movieToEdit,
            onSave = { movie ->
                movieViewModel.addOrUpdateMovie(movie)
                showEditScreen = false
            },
            onCancel = {
                showEditScreen = false
            }
        )
    } else {
        var listType by remember { mutableStateOf(ListType.ROW) }
        Column {
            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { listType = ListType.ROW },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    shape = RoundedCornerShape(size = 8.dp)
                ) {
                    Text("Row")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { listType = ListType.COLUMN },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    shape = RoundedCornerShape(size = 8.dp)
                ) {
                    Text("Column")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { listType = ListType.GRID },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    shape = RoundedCornerShape(size = 8.dp)
                ) {
                    Text("Grid")
                }
                Spacer(modifier = Modifier.width(5.dp))
                Button(
                    onClick = {
                        navController.navigate(ROUTE_SCREEN.screen1.name)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    shape = RoundedCornerShape(size = 8.dp)
                ) {
                    Text("Screen")
                }
            }
            when (listType) {
                ListType.ROW -> MovieRow(
                    movies = moviesState,
                    onEdit = { movie ->
                        movieToEdit = movie
                        showEditScreen = true
                    },
                    onDelete = { movie ->
                        onDelete(movie)
                    }
                )
                ListType.COLUMN -> MovieColumn(
                    movies = moviesState,
                    onEdit = { movie ->
                        movieToEdit = movie
                        showEditScreen = true
                    },
                    onDelete = { movie ->
                        onDelete(movie)
                    }
                )
                ListType.GRID -> MovieGrid(
                    movies = moviesState,
                    onEdit = { movie ->
                        movieToEdit = movie
                        showEditScreen = true
                    },
                    onDelete = { movie ->
                        onDelete(movie)
                    }
                )
            }

        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            FloatingActionButton(
                onClick = {
                    movieToEdit = null
                    showEditScreen = true
                }

            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null, tint = Color.White)
            }
        }
    }
}

@Composable
fun MovieRow(movies: List<Movie>, onEdit: (Movie) -> Unit, onDelete: (Movie) -> Unit) {
    LazyRow(
        state = rememberLazyListState(),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movies.size) { index ->
            val movie = movies[index]
            Column {
                MovieItemExerciseTwo(movie = movie, listType = ListType.ROW, onEdit = onEdit, onDelete = onDelete)
                IconButton(
                    onClick = { onDelete(movie) }, // Gọi hàm xóa khi nhấp vào nút xóa
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete")
                }
            }
        }
    }
}

@Composable
fun MovieColumn(movies: List<Movie>, onEdit: (Movie) -> Unit, onDelete: (Movie) -> Unit) {
    LazyColumn(
        state = rememberLazyListState(),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movies.size) { index ->
            val movie = movies[index]
            Column {
                MovieColumnItem(movie = movie, listType = ListType.COLUMN, onEdit = onEdit, onDelete = onDelete)
                IconButton(
                    onClick = { onDelete(movie) }, // Gọi hàm xóa khi nhấp vào nút xóa
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete")
                }
            }
        }
    }
}

@Composable
fun MovieGrid(movies: List<Movie>, onEdit: (Movie) -> Unit, onDelete: (Movie) -> Unit) {
    val gridState = rememberLazyStaggeredGridState()
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        state = gridState,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalItemSpacing = 8.dp,
        contentPadding = PaddingValues(8.dp)
    ) {
        items(movies.size) { index ->
            val movie = movies[index]
            Column {
                MovieItemExerciseTwo(movie = movie, listType = ListType.GRID, onEdit = onEdit, onDelete = onDelete)
                IconButton(
                    onClick = { onDelete(movie) }, // Gọi hàm xóa khi nhấp vào nút xóa
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete")
                }
            }
        }
    }
}
@Composable
fun MovieColumnItem(movie: Movie, listType: ListType, onEdit: (Movie) -> Unit,onDelete: (Movie) -> Unit) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier.clickable { onEdit(movie) }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = movie.posterUrl,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .then(getItemSizeModifier(listType))
                    .wrapContentHeight()
            )
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                BoldValueText(
                    label = "Thời lượng: ", value = "${movie.duration}'"
                )
                BoldValueText(
                    label = "Khởi chiếu: ", value = movie.releaseDate
                )
                BoldValueText(label = "Thể loại: ", value = movie.genre)
                Text(
                    text = "Tóm tắt nội dung",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 4.dp, bottom = 2.dp)
                )
                Text(
                    text = movie.shortDescription,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(end = 2.dp)
                )
            }
        }
    }
}


@Composable
fun MovieItemExerciseTwo(movie: Movie, listType: ListType, onEdit: (Movie) -> Unit ,onDelete: (Movie) -> Unit) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier.clickable { onEdit(movie) }
    ) {
        Column(modifier = Modifier.then(getItemSizeModifier(listType))) {
            AsyncImage(
                model = movie.posterUrl,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.wrapContentHeight().fillMaxWidth()
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                BoldValueText(
                    label = "Thời lượng: ", value = "${movie.duration}'"
                )
                BoldValueText(
                    label = "Khởi chiếu: ", value = movie.releaseDate
                )
            }
        }
    }
}
@Composable
fun BoldValueText(label: String, value: String, style: TextStyle = MaterialTheme.typography.bodySmall) {
    Text(buildAnnotatedString {
        append(label)
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append(value)
        }
    }, style = style)
}

@Composable
private fun getItemSizeModifier(listType: ListType): Modifier {
    return when (listType) {
        ListType.ROW -> Modifier.width(175.dp)
        ListType.COLUMN -> Modifier.width(130.dp)
        ListType.GRID -> Modifier.fillMaxWidth()
    }
}
