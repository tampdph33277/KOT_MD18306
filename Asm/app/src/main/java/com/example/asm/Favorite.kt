package com.example.asm

import android.content.ClipData.Item
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.asm.customcompose.ItemCartCompose
import com.example.asm.ui.theme.AsmTheme

class Favorite : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingFavorite(NavController(context = LocalContext.current))
        }
    }
}
@Composable
fun GreetingFavorite(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        // LazyColumn để cuộn qua các mục ItemCartCompose()
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp), // Chừa không gian cho nút Button
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    IconButton(
                        onClick = { /* Thêm hành động ở đây */ },
                        modifier = Modifier
                            .weight(1f)
                            .padding(top = 8.dp, end = 8.dp)
                            .size(30.dp, 30.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp, 20.dp)
                        )
                    }
                    Text(
                        text = "Favorites",
                        fontFamily = FontFamily.Serif,
                        color = Color(0xff000000),
                        fontWeight = FontWeight(500),
                        fontSize = 20.sp,
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                    IconButton(
                        onClick = { /* Thêm hành động ở đây */ },
                        modifier = Modifier
                            .weight(1f)
                            .padding(top = 8.dp, end = 8.dp)
                            .size(30.dp, 30.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.cart),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp, 20.dp)
                        )
                    }
                }
            }
            // Thêm các mục ItemCartCompose() vào LazyColumn
            items(5) {
                ItemCartCompose()
                Spacer(modifier = Modifier.height(10.dp))
            }
        }

        // Nút Button được đặt cố định ở cuối màn hình
        Button(
            onClick = {
                navController.navigate("cart")
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp) // Khoảng cách từ nút Button đến cạnh dưới của màn hình
                .size(270.dp, 60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff242424)
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Add all to my cart",
                fontFamily = FontFamily.Serif
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingFavoritePreview() {
    GreetingFavorite(NavController(context = LocalContext.current))
}