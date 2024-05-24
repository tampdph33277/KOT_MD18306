package com.example.asm

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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.asm.customcompose.ItemCartCompose

class Checkout : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingCheckout(NavController(context = LocalContext.current))
        }
    }
}

@Composable
fun GreetingCheckout(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
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
                        painter = painterResource(id = R.drawable.left),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp, 20.dp)
                    )
                }
                Text(
                    text = "Check out",
                    fontFamily = FontFamily.Serif,
                    color = Color(0xff000000),
                    fontWeight = FontWeight(500),
                    fontSize = 20.sp,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                Spacer(modifier = Modifier.weight(1f)) // Spacer để căn giữa "My cart"

            }
            // LazyColumn để cuộn qua các mục ItemCartCompose()
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // Cho phép LazyColumn chiếm toàn bộ không gian còn lại
                    .padding(bottom = 10.dp), // Chừa không gian cho nút Button
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Cột chứa nội dung
                item {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Hàng chứa văn bản và biểu tượng
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp, end = 10.dp)
                        ) {
                            // Văn bản
                            Text(
                                text = "Shipping Address",
                                fontFamily = FontFamily.Serif,
                                color = Color(0xFF585353),
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                                modifier = Modifier.align(Alignment.CenterVertically) // Đẩy Text này ra mép phải
                            )
                            // Biểu tượng
                            Icon(
                                painter = painterResource(id = R.drawable.but),
                                contentDescription = "Icon",
                                modifier = Modifier.size(20.dp)
                            )
                        }

                        // Cột chứa hai dòng văn bản
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .background(Color.White, shape = RoundedCornerShape(8.dp))
                                .padding(8.dp)
                        ) {
                            // Dòng văn bản thứ nhất
                            Text(
                                text = "Phùng Đức Tâm",
                                fontFamily = FontFamily.Serif,
                                color = Color(0xFF000000),
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                           //     modifier = Modifier.align(Alignment.CenterVertically) // Đẩy Text này ra mép phải
                            )
                            // Dòng văn bản thứ hai
                            Spacer(modifier = Modifier.height(5.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(1.dp)

                                    .background(color = Color(0xffBDBDBD))
                            ) {}
                            Spacer(modifier = Modifier.height(5.dp))

                            Text(
                                text = "25 rue Robert Latouche, Nice, 06200, Côte D’azur, France",
                                fontFamily = FontFamily.Serif,
                                color = Color(0xFF585353),
                                fontWeight = FontWeight(500),
                                fontSize = 15.sp,
                      //          modifier = Modifier.align(Alignment.CenterVertically) // Đẩy Text này ra mép phải
                            )
                        }
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Hàng chứa văn bản và biểu tượng
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp, end = 10.dp)
                        ) {
                            // Văn bản
                            Text(
                                text = "Payment",
                                fontFamily = FontFamily.Serif,
                                color = Color(0xFF585353),
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                                modifier = Modifier.align(Alignment.CenterVertically) // Đẩy Text này ra mép phải
                            )
                            // Biểu tượng
                            Icon(
                                painter = painterResource(id = R.drawable.but),
                                contentDescription = "Icon",
                                modifier = Modifier.size(20.dp)
                            )
                        }

                        // Cột chứa hai dòng văn bản
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .background(Color.White, shape = RoundedCornerShape(8.dp))
                                .padding(8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                        ) {

                            Image(
                                painter = painterResource(id = R.drawable.group),
                                contentDescription = "",
                                modifier = Modifier
                                    .width(50.dp)
                                    .height(30.dp)

                                    .shadow(
                                        elevation = 1.dp,
                                        shape = RoundedCornerShape(
                                            5.dp
                                        )
                                    )
                            )
                            Spacer(modifier = Modifier.width(9.dp))
                            Text(
                                text = "25 rue Robert Latouche, Nice, 06200, Côte D’azur, France",
                                fontFamily = FontFamily.Serif,
                                color = Color(0xFF585353),
                                fontWeight = FontWeight(500),
                                fontSize = 15.sp,
                                //          modifier = Modifier.align(Alignment.CenterVertically) // Đẩy Text này ra mép phải
                            )
                        }
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Hàng chứa văn bản và biểu tượng
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp, end = 10.dp)
                        ) {
                            // Văn bản
                            Text(
                                text = "Delivery method",
                                fontFamily = FontFamily.Serif,
                                color = Color(0xFF585353),
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                                modifier = Modifier.align(Alignment.CenterVertically) // Đẩy Text này ra mép phải
                            )
                            // Biểu tượng
                            Icon(
                                painter = painterResource(id = R.drawable.but),
                                contentDescription = "Icon",
                                modifier = Modifier.size(20.dp)
                            )
                        }

                        // Cột chứa hai dòng văn bản
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .background(Color.White, shape = RoundedCornerShape(8.dp))
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Image(
                                painter = painterResource(id = R.drawable.co),
                                contentDescription = "",
                                modifier = Modifier
                                    .width(70.dp)
                                    .height(20.dp)

                                    .shadow(
                                        elevation = 1.dp,
                                        shape = RoundedCornerShape(
                                            5.dp
                                        )
                                    )
                            )
                            Spacer(modifier = Modifier.width(9.dp))
                            Text(
                                text = "25 rue Robert Latouche, Nice, 06200, Côte D’azur, France",
                                fontFamily = FontFamily.Serif,
                                color = Color(0xFF585353),
                                fontWeight = FontWeight(500),
                                fontSize = 15.sp,
                                //          modifier = Modifier.align(Alignment.CenterVertically) // Đẩy Text này ra mép phải
                            )
                        }
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .padding(16.dp)
                            .background(Color.White, shape = RoundedCornerShape(8.dp))
                            .padding(8.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()

                        ) {
                            // Dòng văn bản thứ nhất
                            Text(
                                text = "My cart",
                                fontFamily = FontFamily.Serif,
                                color = Color(0xff808080),
                                fontWeight = FontWeight(500),
                                fontSize = 15.sp,
                                modifier = Modifier.weight(1f, fill = false) // Đẩy Text này ra mép trái
                            )
                            Spacer(modifier = Modifier.weight(4f)) // Spacer chiếm khoảng trống ở giữa
                            Text(
                                text = "$ 95.00",
                                fontFamily = FontFamily.Serif,
                                color = Color(0xff000000),
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                                modifier = Modifier.align(Alignment.CenterVertically) // Đẩy Text này ra mép phải
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp, bottom = 10.dp)
                        ) {
                            // Dòng văn bản thứ nhất
                            Text(
                                text = "Delivery:",
                                fontFamily = FontFamily.Serif,
                                color = Color(0xff808080),
                                fontWeight = FontWeight(500),
                                fontSize = 15.sp,
                                modifier = Modifier.weight(1f, fill = false) // Đẩy Text này ra mép trái
                            )
                            Spacer(modifier = Modifier.weight(3f)) // Spacer chiếm khoảng trống ở giữa
                            Text(
                                text = "$ 95.00",
                                fontFamily = FontFamily.Serif,
                                color = Color(0xff000000),
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                                modifier = Modifier.align(Alignment.CenterVertically) // Đẩy Text này ra mép phải
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()

                        ) {
                            // Dòng văn bản thứ nhất
                            Text(
                                text = "Total:",
                                fontFamily = FontFamily.Serif,
                                color = Color(0xff808080),
                                fontWeight = FontWeight(500),
                                fontSize = 15.sp,
                                modifier = Modifier.weight(1f, fill = false) // Đẩy Text này ra mép trái
                            )
                            Spacer(modifier = Modifier.weight(5.6f)) // Spacer chiếm khoảng trống ở giữa
                            Text(
                                text = "$ 95.00",
                                fontFamily = FontFamily.Serif,
                                color = Color(0xff000000),
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                                modifier = Modifier.align(Alignment.CenterVertically) // Đẩy Text này ra mép phải
                            )
                        }

                    }
                }

            }


            // Hàng chứa "My cart" và "Total"


            // Nút Button được đặt cố định ở cuối màn hình
            Button(
                onClick = {
                    navController.navigate("checkout")
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 20.dp) // Khoảng cách từ nút Button đến cạnh dưới của màn hình
                    .size(270.dp, 60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff242424)
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "SUBMIT ORDER",
                    fontFamily = FontFamily.Serif
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingCheckoutPreview() {
    GreetingCheckout(NavController(context = LocalContext.current))
}
