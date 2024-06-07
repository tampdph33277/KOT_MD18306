package com.example.lab7

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.congntph34559.fpoly.lab7_kot104_ph34559_application.ui.screens.LoginScreen

@Composable
fun GetLayoutScreenNavigation() {

    val navController = rememberNavController()
    val movieViewModel: MovieViewModel = viewModel()
    val moviesState = movieViewModel.movies.observeAsState(initial = emptyList())
    NavHost(navController = navController, startDestination = ROUTE_SCREEN.login.name) {
        composable(ROUTE_SCREEN.login.name) { LoginScreen(navController) }
        composable(ROUTE_SCREEN.movie.name) {
            Movie(
                moviesState.value,
                navController
            )
        }
        composable(ROUTE_SCREEN.screen1.name) { GetLayoutScreenOne(navController) }
        composable(ROUTE_SCREEN.screen2.name) { GetLayoutScreenTwo(navController) }
        composable(ROUTE_SCREEN.screen3.name) { GetLayoutScreenThree(navController) }
    }


}
@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    GetLayoutScreenNavigation()
}