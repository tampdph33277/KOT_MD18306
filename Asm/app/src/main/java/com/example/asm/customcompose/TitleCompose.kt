package com.example.asm.customcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.asm.R


@Composable
fun TitleCompose() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
                .background(color = Color(0xffBDBDBD))
        ) {}
        Image(
            painter = painterResource(id = R.drawable.logo), contentDescription
            = "logo",
            modifier = Modifier
                .padding(start = 30.dp, end = 30.dp)
                .size(50.dp, 50.dp)
                .weight(1f)
        )
        Row(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
                .background(color = Color(0xffBDBDBD))
        ) {}
    }


}

@Preview(showBackground = true)
@Composable
fun PreviewCompose() {
    TitleCompose()
}