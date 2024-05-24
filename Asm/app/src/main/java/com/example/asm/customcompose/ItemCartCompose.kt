package com.example.asm.customcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.asm.R


@Composable
fun ItemCartCompose() {
Column(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.sp1), contentDescription
            = "logo",
            modifier = Modifier
                .padding( 10.dp)
                .size(120.dp, 120.dp)
                .shadow(
                    elevation = 1.dp,
                    shape = RoundedCornerShape(
                        20.dp,
                    )
                )
        )
        Column(
            modifier = Modifier


        ) {
            Text(
                text = "Minimal Stand",
                fontFamily = FontFamily.Serif,
                color = Color(0xff909090),
                fontWeight = FontWeight(500),
                fontSize = 18.sp,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Text(
                text = "$ 25.00",
                fontFamily = FontFamily.Serif,
                color = Color(0xff000000),
                fontWeight = FontWeight(500),
                fontSize = 20.sp,
                modifier = Modifier.padding(horizontal = 20.dp)
            )

            SoluogCompose( )
        }
        Column(
            modifier = Modifier

        ) {
            IconButton(
                onClick = { /* Thêm hành động ở đây */ },
                modifier = Modifier

                    .padding(top = 8.dp, end = 8.dp) // Thêm khoảng cách 8dp ở trên và bên phải
                    .size(30.dp, 30.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.shape),
                    contentDescription = null,
                    modifier = Modifier.size(15.dp, 15.dp)
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            IconButton(
                onClick = { /* Thêm hành động ở đây */ },
                modifier = Modifier


                    .padding(top = 8.dp, end = 8.dp) // Thêm khoảng cách 8dp ở trên và bên phải
                    .size(30.dp, 30.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.shopping_bag),
                    contentDescription = null,
                    modifier = Modifier.size(15.dp, 15.dp)
                )
            }
        }

    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .padding(start = 20.dp, end = 20.dp)
            .background(color = Color(0xffBDBDBD))
    ) {}
}


}

@Preview(showBackground = true)
@Composable
fun PreviewItemCartCompose() {
    ItemCartCompose()
}