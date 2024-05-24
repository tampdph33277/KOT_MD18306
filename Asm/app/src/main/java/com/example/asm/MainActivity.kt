package com.example.asm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "boarding") {
        composable("boarding") { GetLayoutBoarding(navController) }
        composable("login") { GreetingLayoutLogin(navController) }
        composable("signup") { GetLayoutSignUp(navController) }
        composable("home") { GetLayoutHome(navController) }
        composable("product") { GreetinglayoutProduct(navController) }
        composable("favorite") { GreetingFavorite(navController) }
        composable("cart") { GreetingCart(navController) }
        composable("checkout") { GreetingCheckout(navController) }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    AppNavigation()
}
