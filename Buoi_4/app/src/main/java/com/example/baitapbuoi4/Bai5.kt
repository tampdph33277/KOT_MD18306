package com.example.baitapbuoi4


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt

class Bai5 : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text("Thanh toán")
                        },
                        navigationIcon = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Filled.Menu, contentDescription = "")
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color("#70cbff".toColorInt()),
                            titleContentColor = MaterialTheme.colorScheme.onPrimary,
                            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                            actionIconContentColor = MaterialTheme.colorScheme.onSecondary
                        )
                    )
                },
                content = {
                    GetLayout("Thanh Toán", "Địa chỉ nhận hàng","Vui lòng chọn 1 trong phương thức sau", R.drawable.location, it)
                }
            )
        }
    }

    @Preview
    @Composable
    fun GetLayout(
        title: String = "Thanh Toán",
        title1: String = "Địa chỉ nhận hàng",
        title2: String = "Vui lòng chọn 1 trong phương thức sau :",
        img: Int = R.drawable.location,
        innerPadding: PaddingValues = PaddingValues(0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color("#363232".toColorInt()))
                .padding(
                    top = innerPadding.calculateTopPadding() + 10.dp,
                    start = 10.dp,
                    end = 10.dp,
                    bottom = 10.dp
                ),

            ) {
            GetTextTitle(title = title)
            GetTextTitle1(title = title1)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(10.dp)
            ) {
                GetImg(img = img)
                Spacer(modifier = Modifier.width(10.dp))  // Thêm khoảng cách giữa hình ảnh và văn bản nếu cần
                Column {
                    Text(
                        text = "Tâm|222222",
                        color = Color.White,
                        fontSize = 10.sp
                    )
                    Text(
                        text = "số nhà 8",
                        color = Color.White,
                        fontSize = 10.sp
                    )
                    Text(
                        text = "Phường Đức Thắng",
                        color = Color.White,
                        fontSize = 10.sp
                    )
                    Text(
                        text = "Quận Bắc Từ Liêm , Hà Nội ",
                        color = Color.White,
                        fontSize = 10.sp
                    )
                }
            }
            GetTextTitle2(title = title2)
            GetRowItem(color = Color("#fa8500".toColorInt()), idRes = R.drawable.a, noidungtext = "Paypal")
            GetRowItem(color = Color("#ffffff".toColorInt()), idRes = R.drawable.d, noidungtext = "Visa")
            GetRowItem(color = Color("#ec1387".toColorInt()), idRes = R.drawable.b, noidungtext = "Momo")
            GetRowItem(color = Color("#00c2fd".toColorInt()), idRes = R.drawable.c, noidungtext = "Zalopay")
            GetRowItem1(color = Color("#fe734c".toColorInt()), noidungtext = "Tiếp theo")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                GetRowImg2(color = Color("#fe734c".toColorInt()), img2 = R.drawable.e,img3 = R.drawable.f,img4 = R.drawable.h)
            }
        }
    }

    @Composable
    fun GetRowItem(color: Color, idRes: Int, noidungtext: String) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(5.dp)
                .background(color = color, shape = RoundedCornerShape(15.dp))
                .height(50.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = idRes),
                contentDescription = null,
                modifier = Modifier
                    .width(60.dp)
                    .padding(5.dp)
            )

            Text(
                text = noidungtext,
                modifier = Modifier
                    .weight(1f)
                    .padding(50.dp, 0.dp, 0.dp, 0.dp),
                color = Color.White
            )

            RadioButton(selected = false, onClick = { /*TODO*/ })
        }
    }
    @Composable
    fun GetRowItem1(color: Color, noidungtext: String) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(5.dp, top = 90.dp)
                .offset(x = 35.dp)
                .background(color = color, shape = RoundedCornerShape(15.dp))
                .height(50.dp)
                .width(300.dp)
        ) {
            Text(
                text = noidungtext,
                modifier = Modifier
                    .weight(1f),
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
            )
        }
    }

    @Composable
    fun GetRowImg2(color: Color,img2: Int, img3:Int,img4:Int) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(5.dp, top = 120.dp)
                .background(color = Color("#ffffff".toColorInt()), shape = RoundedCornerShape(15.dp))
                .fillMaxWidth()
                .height(80.dp)
        ) {
            Image(
                painter = painterResource(id = img2),
                contentDescription = null,
                modifier = Modifier
                    .width(50.dp)
                    .padding(5.dp).offset(x =  50.dp)
            )

            Image(
                painter = painterResource(id = img3),
                contentDescription = null,
                modifier = Modifier
                    .width(50.dp)
                    .padding(5.dp).offset(x =  100.dp)
            )

            Image(
                painter = painterResource(id = img4),
                contentDescription = null,
                modifier = Modifier
                    .width(50.dp)
                    .padding(5.dp).offset(x =  150.dp)
            )


        }
    }


    @Composable
    fun GetTextTitle(title: String) {
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            fontSize = 30.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }

    @Composable
    fun GetTextTitle1(title: String) {
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            fontSize = 10.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
        )
    }

    @Composable
    fun GetTextTitle2(title: String) {
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            fontSize = 10.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
        )
    }

    @Composable
    fun GetImg(img: Int) {
        Image(
            painter = painterResource(id = img),
            contentDescription = null,
            modifier = Modifier
                .width(30.dp)
                .padding(5.dp)
        )
    }
}
