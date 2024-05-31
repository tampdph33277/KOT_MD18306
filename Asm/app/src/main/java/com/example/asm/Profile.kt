package com.example.assph34559application

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.asm.R

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GetLayoutProfile(NavHostController(LocalContext.current))
        }

    }
}

@Composable
fun GetLayoutProfile(navController: NavHostController) {
    val stateScroller = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 25.dp, top = 30.dp, end = 25.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = null,
                modifier = Modifier.size(20.dp, 20.dp),
                tint = Color(0xff242424)
            )
            Text(
                text = "Profile",
                modifier = Modifier,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontSize = 18.sp,
                fontWeight = FontWeight(700)
            )
            Icon(
                painter = painterResource(id = R.drawable.exit),
                contentDescription = null,
                modifier = Modifier.size(20.dp, 20.dp),
                tint = Color(0xff242424)
            )


        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 20.dp, start = 10.dp, end
                    = 10.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.avater),
                contentDescription = null,
                modifier = Modifier.size(80.dp, 80.dp)
            )
            Column(
                modifier = Modifier.padding(start = 20.dp)
            ) {
                Text(
                    text = "Bruno Pham",
                    fontWeight = FontWeight(700),
                    fontSize = 20.sp,
                    color = Color(0xff303030),
                    fontFamily = FontFamily.Serif
                )
                Text(
                    text = "bruno203@gmail.com",
                    fontWeight = FontWeight(400),
                    fontSize = 14.sp,
                    color = Color(0xff808080),
                    fontFamily = FontFamily.Serif
                )
            }

        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(stateScroller)
        ) {

            Column(
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp, top = 30.dp, bottom = 15.dp)
                    .fillMaxWidth()
                    .height(80.dp)
                    .shadow(
                        elevation = 5.dp,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .background(
                        Color.White,
                        shape = RoundedCornerShape(10.dp)
                    ).selectable(
                        selected = true,
                        onClick = {
                        }
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text(
                            text = "My orders",
                            fontSize = 18.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight(700)
                        )
                        Text(
                            text = "Already have 10 orders",
                            fontSize = 12.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight(400),
                            color = Color(0xff808080)
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp, 24.dp)
                        )
                    }

                }
            }

            Column(
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 15.dp)
                    .fillMaxWidth()
                    .height(80.dp)
                    .shadow(
                        elevation = 5.dp,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .background(
                        Color.White,
                        shape = RoundedCornerShape(10.dp)
                    ).selectable(
                        selected = true,
                        onClick = {
                        }
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text(
                            text = "Shipping Addresses",
                            fontSize = 18.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight(700)
                        )
                        Text(
                            text = "03 Addresses",
                            fontSize = 12.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight(400),
                            color = Color(0xff808080)
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp, 24.dp)
                        )
                    }

                }
            }

            Column(
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 15.dp)
                    .fillMaxWidth()
                    .height(80.dp)
                    .shadow(
                        elevation = 5.dp,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .background(
                        Color.White,
                        shape = RoundedCornerShape(10.dp)
                    ).selectable(
                        selected = true,
                        onClick = {
                       }
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text(
                            text = "Payment Method",
                            fontSize = 18.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight(700)
                        )
                        Text(
                            text = "You have 2 cards",
                            fontSize = 12.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight(400),
                            color = Color(0xff808080)
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp, 24.dp)
                        )
                    }

                }
            }

            Column(
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 15.dp)
                    .fillMaxWidth()
                    .height(80.dp)
                    .shadow(
                        elevation = 5.dp,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .background(
                        Color.White,
                        shape = RoundedCornerShape(10.dp)
                    ).selectable(
                        selected = true,
                        onClick = {
                       }
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text(
                            text = "My reviews",
                            fontSize = 18.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight(700)
                        )
                        Text(
                            text = "Reviews for 5 items",
                            fontSize = 12.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight(400),
                            color = Color(0xff808080)
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp, 24.dp)
                        )
                    }

                }
            }

            Column(
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 15.dp)
                    .fillMaxWidth()
                    .height(80.dp)
                    .shadow(
                        elevation = 5.dp,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .background(
                        Color.White,
                        shape = RoundedCornerShape(10.dp)
                    ).selectable(
                        selected = true,
                        onClick = {
                        }
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text(
                            text = "Setting",
                            fontSize = 18.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight(700)
                        )
                        Text(
                            text = "Notification, Password, FAQ, Contact",
                            fontSize = 12.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight(400),
                            color = Color(0xff808080)
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp, 24.dp)
                        )
                    }

                }
            }


        }


    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingProfile() {
    GetLayoutProfile(NavHostController(LocalContext.current))
}