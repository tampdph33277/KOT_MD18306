package com.example.asm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

class NotificationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetLayoutNotification(NavHostController(LocalContext.current))
        }
    }
}

class Notification(var image: Int, var title: String, var desc: String)

var listNotificationOne = mutableListOf<Notification>(
    Notification(
        R.drawable.image_product2,
        "Your order #123456789 has been confirmed",
        "Lorem ipsum dolor sit amet, consecrate disciplining elite. Turps premium et in arc disciplining nec. Turps premium et in arc disciplining nec."
    ),
    Notification(
        R.drawable.image_product2,
        "Your order #123456789 has been confirmed",
        "Lorem ipsum dolor sit amet, consecrate disciplining elite. Turps premium et in arc disciplining nec. Turps premium et in arc disciplining nec."
    ),

    )
var listNotificationTwo = mutableListOf<Notification>(
    Notification(
        R.drawable.image_product2,
        "Your order #123456789 has been confirmed",
        "Lorem ipsum dolor sit amet, consecrate disciplining elite. Turps premium et in arc disciplining nec. Turps premium et in arc disciplining nec."
    ),
    Notification(
        R.drawable.image_product2,
        "Your order #123456789 has been confirmed",
        "Lorem ipsum dolor sit amet, consecrate disciplining elite. Turps premium et in arc disciplining nec. Turps premium et in arc disciplining nec."
    ),
    Notification(
        R.drawable.image_product2,
        "Your order #123456789 has been confirmed",
        "Lorem ipsum dolor sit amet, consecrate disciplining elite. Turps premium et in arc disciplining nec. Turps premium et in arc disciplining nec."
    ),
    Notification(
        R.drawable.image_product2,
        "Your order #123456789 has been confirmed",
        "Lorem ipsum dolor sit amet, consecrate disciplining elite. Turps premium et in arc disciplining nec. Turps premium et in arc disciplining nec."
    ),

    )


@Composable
fun GetLayoutNotification(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 25.dp, top = 30.dp, end = 25.dp
                ), verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = null,
                modifier = Modifier.size(20.dp, 20.dp),
                tint = Color(0xff242424)
            )
            Text(
                text = "Notification",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontSize = 18.sp,
                fontWeight = FontWeight(700)
            )


        }


        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            LazyColumn(
                modifier = Modifier
                    .padding(top = 25.dp)
                    .fillMaxSize()
                    .weight(1f)
            ) {
                items(listNotificationOne) {
                    ItemNotification(it)
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .background(Color(0xffF0F0F0))
                    .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 10.dp)
            ) {
                Text(
                    text = "Discover hot sale furnitures this week.",
                    fontFamily = FontFamily.Serif,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(700),
                    modifier = Modifier.padding(bottom = 5.dp)
                )
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                            "Turpis pretium et in arcu adipiscing nec. Turpis pretium et in arcu adipiscing nec. Turpis pretium et in arcu adipiscing nec. ",
                    fontFamily = FontFamily.Serif,
                    fontSize = 10.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xff808080),
                    textAlign = TextAlign.Justify,
                    lineHeight = 15.sp

                )
                Text(
                    text = "HOT!",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight(800),
                    color = Color(0xffEB5757)
                )

            }

            LazyColumn(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxSize()
                    .weight(2f)

            ) {
                items(listNotificationTwo){
                    ItemNotification(item = it)
                }

            }


        }


    }


}

@Composable
fun ItemNotification(item: Notification) {
    Column(
        modifier = Modifier.padding(start = 10.dp, end = 10.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = item.image),
                contentDescription = null,
                modifier = Modifier
                    .size(70.dp, 70.dp)
                    .clip(
                        shape = RoundedCornerShape(10.dp)
                    ),
                contentScale = ContentScale.Crop,
            )
            Column(
                modifier = Modifier.padding(start = 10.dp),
            ) {
                Text(
                    text = item.title,
                    fontFamily = FontFamily.Serif,
                    fontSize = 12.sp,
                    fontWeight = FontWeight(700),
                    modifier = Modifier.padding(bottom = 5.dp)

                )
                Text(
                    text = item.desc,
                    fontFamily = FontFamily.Serif,
                    fontSize = 10.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xff808080),
                    textAlign = TextAlign.Justify,
                    lineHeight = 15.sp
                )
            }


        }

    }
    Spacer(modifier = Modifier.height(15.dp))
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingNotification() {
    GetLayoutNotification(NavHostController(LocalContext.current))
}