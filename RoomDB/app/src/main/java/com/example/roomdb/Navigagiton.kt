package com.example.roomdb


import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

enum class ROUTE {
    list,
    insert,
    update,
}


@Composable
fun GetLayoutAppNavigation() {
    var navController = rememberNavController()

    NavHost(navController = navController, startDestination = ROUTE.list.name) {
        composable(ROUTE.list.name) { GetLayoutHomeScreen(navController) }
        composable(ROUTE.insert.name) { GetLayoutInsertStudent(navController) }

        composable(
            "${ROUTE.update.name}/{id}",
            arguments = listOf(
                navArgument(name = "id") {
                    type = NavType.IntType
                }
            )
        ) {backStackEntry->
            GetLayoutUpdateStudent(
                navController,
                backStackEntry.arguments?.getInt("id",0)
            )
        }
        composable(ROUTE.update.name) { GetLayoutHomeScreen(navController) }
    }

}