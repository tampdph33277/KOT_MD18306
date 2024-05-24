package com.example.asm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.asm.customcompose.SoluogCompose

class Produc : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetinglayoutProduct(NavController(context = LocalContext.current))
            }
        }
    }


@Composable
fun GreetinglayoutProduct(navController: NavController) {
    val scrollSate = rememberScrollState()
    Column( modifier = Modifier
        .fillMaxSize()

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(fraction = 1f)
                .fillMaxHeight(fraction = 0.6f) //  Chiều cao box sẽ chiếm 70% chiều cao của parent
                .border(width = 0.dp, color = Color.Transparent) // Bỏ viền border
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_product2),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .offset(x = (50).dp, y = (0).dp)
                    .shadow(
                        elevation = 1.dp,
                        shape = RoundedCornerShape(
                            bottomStart = 50.dp,
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 40.dp)
                    .offset(x = (25).dp, y = (0).dp)
            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .background(
                            color = Color.Gray.copy(alpha = 0.2f),
                            shape = RoundedCornerShape(10.dp)
                )) {
                    Icon(
                        painter = painterResource(id = R.drawable.left),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp, 20.dp),

                    )
                }
                Spacer(modifier = Modifier.height(90.dp))
                Column(
                    modifier = Modifier
                        .background(
                            color = Color.Gray.copy(alpha = 0.2f),
                            shape = RoundedCornerShape(30.dp))
                ) {
                    IconButton(onClick = {  }) {
                        Icon(
                            painter = painterResource(id = R.drawable.co1),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp, 20.dp),
                            tint = Color(0xff70cbff)
                        )
                    }
                    IconButton(onClick = {  }) {
                        Icon(
                            painter = painterResource(id = R.drawable.co2),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp, 20.dp),
                            tint = Color(0xffE4CBAD)
                        )
                    }
                    IconButton(onClick = {  }) {
                        Icon(
                            painter = painterResource(id = R.drawable.co3),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp, 20.dp),
                            tint = Color(0xffcb70dd)
                        )
                }}
            }

        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight(fraction = 0.5f)
        ){
            Column(
                modifier = Modifier
                    .padding(10.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Minimal Stand",
                    fontFamily = FontFamily.Serif,
                    color = Color(0xff606060),
                    fontSize = 24.sp,
                    fontWeight = FontWeight(600)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "$ 50",
                        fontFamily = FontFamily.Serif,
                        color = Color(0xff606060),
                        fontSize = 24.sp,
                        fontWeight = FontWeight(600)
                    )
                    SoluogCompose()
                }
                Spacer(modifier = Modifier.height(10.dp))
               Row(
                   modifier = Modifier
                       .fillMaxWidth(),
                           verticalAlignment = Alignment.CenterVertically,
                   horizontalArrangement = Arrangement.Start

               ) {
                   Icon(
                       painter = painterResource(id = R.drawable.popular),
                       contentDescription = null,
                       modifier = Modifier.size(20.dp, 20.dp),
                       tint = Color(0xffF2C94C)
                   )
                   Text(
                       text = "4.5 ",
                       fontFamily = FontFamily.Serif,
                       color = Color(0xff606060),
                       fontSize = 20.sp,
                       fontWeight = FontWeight(600)
                   )
                   Text(
                       text = " (50 reviews)",
                       fontFamily = FontFamily.Serif,
                       color = Color(0xff606060),
                       fontSize = 15.sp,
                       fontWeight = FontWeight(600)
                   )
               }
                Text(
                    text = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home. ",
                    fontFamily = FontFamily.Serif,
                    color = Color(0xff606060),
                    fontSize = 15.sp,
                    fontWeight = FontWeight(200)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .size(60.dp, 60.dp) // Thiết lập kích thước IconButton
                            .background(
                                color = Color.Gray.copy(alpha = 0.2f),
                                shape = RoundedCornerShape(10.dp)
                            )) {
                        Icon(
                            painter = painterResource(id = R.drawable.marker),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp, 20.dp),

                            )
                    }

                    Button(
                        onClick = {
                            navController.navigate("cart")
                        },
                        modifier = Modifier.size(270.dp, 60.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xff242424)
                        ),
                        shape = RoundedCornerShape(8.dp)

                    ) {
                        Text(
                            text = "Add to cart",
                            fontFamily = FontFamily.Serif,
                                    fontWeight = FontWeight(500),
                            fontSize = 20.sp,
                        )
                    }

                }

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreviewProduct() {
    GreetinglayoutProduct(NavController(context = LocalContext.current))
}