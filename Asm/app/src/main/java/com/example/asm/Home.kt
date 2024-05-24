package com.example.asm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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
import androidx.navigation.NavController

class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           GetLayoutHome(NavController(context = LocalContext.current))
        }
    }
}

class TypeProduct(var type: String, var icon: Int)
class Product(
    var name: String, var price: Float, var description: String,
    var quantityStart: Float, var img: Int,
)

var listProduct = mutableListOf(
    Product(
        "Black Simple Lamp", 12.00f, "Minimal Stand is made of by natural wood. The " +
                "design that is very simple and minimal. This is truly one of the best " +
                "furniture's in any family for now. With 3 different colors, you can easily " +
                "select the best match for your home.", 5.0f, R.drawable.image_product1
    ),
    Product(
        "Minimal Stand", 25.00f, "Minimal Stand is made of by natural wood. The " +
                "design that is very simple and minimal. This is truly one of the best " +
                "furniture's in any family for now. With 3 different colors, you can easily " +
                "select the best match for your home.", 5.0f, R.drawable.image_product2
    ),
    Product(
        "Coffee Chair", 20.00f, "Minimal Stand is made of by natural wood. The " +
                "design that is very simple and minimal. This is truly one of the best " +
                "furniture's in any family for now. With 3 different colors, you can easily " +
                "select the best match for your home.", 5.0f, R.drawable.image_product3
    ),
    Product(
        "Simple Desk", 50.00f, "Minimal Stand is made of by natural wood. The " +
                "design that is very simple and minimal. This is truly one of the best " +
                "furniture's in any family for now. With 3 different colors, you can easily " +
                "select the best match for your home.", 5.0f, R.drawable.image_product4
    ),
)

@Composable
fun GetLayoutHome(navController: NavController) {
    val scrollSate = rememberScrollState()
    var statusType by remember {
        mutableStateOf("Popular")
    }
    val listTypeProduct = mutableListOf(
        TypeProduct("Popular", R.drawable.popular),
        TypeProduct("Chair", R.drawable.chair),
        TypeProduct("Table", R.drawable.table),
        TypeProduct("Armchair", R.drawable.armchair),
        TypeProduct("Bed", R.drawable.bed),
        TypeProduct("Lamb", R.drawable.lamp2),
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        //Title
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp, 20.dp),
                    tint = Color(0xff808080)
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Make home",
                    fontFamily = FontFamily.Serif,
                    fontSize = 15.sp,
                    color = Color(0xff909090)
                )
                Text(
                    text = "BEAUTIFUL",
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700)

                )
            }

            IconButton(onClick = {      navController.navigate("cart") }) {
                Icon(
                    painter = painterResource(id = R.drawable.cart),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp, 20.dp),
                    tint = Color(0xff808080)

                )
            }
        }
        //Type
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 20.dp
                )
                .horizontalScroll(scrollSate),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            listTypeProduct.forEachIndexed { _, type ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .padding(end = 10.dp)
                ) {
                    IconButton(
                        onClick = {
                            statusType = type.type
                        },
                        modifier = Modifier
                            .shadow(
                                elevation = 1.dp,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .background(
                                Color(
                                    if (statusType === type.type) 0xff303030 else 0xffF5F5F5
                                ),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(8.dp)
                    ) {
                        Icon(
                            painterResource(id = type.icon),
                            contentDescription = null,
                            modifier = Modifier.size(26.dp, 26.dp),
                            tint = Color(
                                if (statusType === type.type) 0xffFFFFFF else 0xff909090
                            )
                        )
                    }
                    Text(
                        text = type.type,
                        modifier = Modifier.padding(top = 10.dp),
                        fontFamily = FontFamily.Serif
                    )
                }
            }
        }

        //ListProduct
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp)
        ) {
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(listProduct) { item ->
                    ItemProduct(model = item)
                }
            }
        }


    }


}

@Composable
fun ItemProduct(model: Product) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(end = 25.dp, bottom = 15.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            Image(
                painter = painterResource(id = model.img),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.FillWidth,
            )
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(10.dp)
                    .background(
                        Color(0x66606060),
                        shape = RoundedCornerShape(6.dp)
                    )
                    .size(35.dp, 35.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.add_cart3),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp, 20.dp),
                    tint = Color.White
                )
            }
        }


        Text(
            text = model.name,
            modifier = Modifier.padding(top = 10.dp),
            fontSize = 15.sp,
            fontFamily = FontFamily.Serif,
            color = Color(0xff606060)
        )
        Text(
            text = "$ ${model.price}",
            modifier = Modifier.padding(top = 5.dp),
            fontSize = 15.sp,
            fontFamily = FontFamily.Serif,
            color = Color(0xff303030),
            fontWeight = FontWeight(700)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingHomePreview() {
   GetLayoutHome(NavController(context = LocalContext.current))
}