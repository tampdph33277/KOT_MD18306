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
        composable("home") { GetLayoutHomeNavigation(navController) }
        composable("product/{productName}") { backStackEntry ->
            val productName = backStackEntry.arguments?.getString("productName")
            // Tìm sản phẩm dựa trên tên sản phẩm
            val product = listProduct.find { it.name == productName }
            product?.let {
                ProductDetailScreen(navController, it)
            }
        }
        composable("favorite") { GreetingFavorite(navController) }
        composable("cart") { GreetingCart(navController) }
        composable("checkout") { GreetingCheckout(navController) }
        composable("notification") { GetLayoutNotification(navController) }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    AppNavigation()
}
