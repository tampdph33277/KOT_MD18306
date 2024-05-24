package com.example.asm.customcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.asm.R


@Composable
fun SoluogCompose() {

    var count by remember { mutableStateOf(1) }

    Row(
        modifier = Modifier
            .height(50.dp)
            .width(160.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = { count-- },
            modifier = Modifier
                .height(35.dp)

               ) {
            Icon(
                painter = painterResource(id = R.drawable.vector),
                contentDescription = null,
                modifier = Modifier.size(15.dp, 15.dp)
//                    .size(30.dp, 30.dp)
//                .background(
//                    color = Color(0xffBDBDBD),
//                    shape = RoundedCornerShape(10.dp)
//                )
            )
        }

        Text(
            text = count.toString(),
            fontFamily = FontFamily.Serif,
            color = Color(0xff909090),
            fontWeight = FontWeight(500),
            fontSize = 25.sp,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        IconButton(
            onClick = { count-- },
            modifier = Modifier


                     ) {
            Icon(
                painter = painterResource(id = R.drawable.vecter2),
                contentDescription = null,
                modifier = Modifier.size(15.dp, 15.dp)
                .height(15.dp)
//                .size(30.dp, 30.dp)
//                .background(
//                    color = Color(0xffBDBDBD),
//                    shape = RoundedCornerShape(10.dp)
//                )

            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSoluogCompose() {
    SoluogCompose()
}