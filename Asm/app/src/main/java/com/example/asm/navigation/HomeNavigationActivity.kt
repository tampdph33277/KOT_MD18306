package com.example.asm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.assph34559application.GetLayoutProfile


class HomeNavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GetLayoutHomeNavigation(NavHostController(LocalContext.current))
        }


    }
}

@Composable
fun GetLayoutHomeNavigation(navHostController: NavHostController) {
    val navController = rememberNavController()
    var isSelected by remember {
        mutableStateOf("home")
    }
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xffffffff),
                modifier = Modifier.shadow(
                    elevation = 10.dp
                )
            ) {
                IconButton(
                    onClick = {
                        isSelected = "home"
                        navController.navigate("home") {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = null,
                        tint = if (isSelected === "home") Color(0xff242424)
                        else Color(0xff999999)
                    )
                }
                IconButton(
                    onClick = {
                        isSelected = "favorite"
                        navController.navigate("favorite") {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null,
                        tint = if (isSelected === "favorite") Color(0xff242424)
                        else Color(0xff999999)
                    )
                }
                IconButton(
                    onClick = {
                        isSelected = "notification"
                        navController.navigate("notification") {
                            popUpTo(0)
                        }
                    },

                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = null,
                        tint = if (isSelected === "notification") Color(0xff242424)
                        else Color(0xff999999)
                    )
                }
                IconButton(
                    onClick = {
                        isSelected = "profile"
                        navController.navigate("profile") {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = if (isSelected === "profile") Color(0xff242424)
                        else Color(0xff999999)
                    )
                }


            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(it)
        ) {
            composable("home") { GetLayoutHome(navHostController) }
            composable("favorite") { GreetingFavorite(navController) }
            composable("notification") { GetLayoutNotification(navController) }
            composable("profile") { GetLayoutProfile(navHostController) }
            composable("cart") { GreetingCart(navHostController) }

        }


    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingMainNavigation() {
    GetLayoutHomeNavigation(NavHostController(LocalContext.current))
}