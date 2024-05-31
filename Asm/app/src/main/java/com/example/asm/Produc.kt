package com.example.asm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
            val product = intent.getSerializableExtra("product") as? Product
            if (product != null) {
                ProductDetailScreen(navController = NavController(context = LocalContext.current), product = product)
            } else {
                // Handle error or show some default content
            }
        }
    }
}

@Composable
fun ProductDetailScreen(navController: NavController, product: Product) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.64f),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(id = product.img),
                contentDescription = product.name,
                modifier = Modifier
                    .padding(start = 49.dp)
                    .fillMaxSize()
                    .shadow(
                        elevation = 1.dp,
                        shape = RoundedCornerShape(bottomStart = 50.dp)
                    )
            )

            IconButton(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier
                    .padding(end = 260.dp, top = 20.dp)
                    .shadow(
                        elevation = 3.dp,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .size(40.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_back),
                    contentDescription = null,
                    modifier = Modifier.size(15.dp, 15.dp)
                )
            }

            Column(
                modifier = Modifier
                    .padding(end = 260.dp, top = 120.dp)
                    .shadow(
                        elevation = 3.dp,
                        shape = RoundedCornerShape(30.dp)
                    )
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                    .padding(10.dp)
            ) {
                CustomRadioButton(
                    selected = true,
                    onClick = { /*TODO*/ },
                    outerColor = Color.Gray,
                    innerColor = Color.White
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomRadioButton(
                    selected = false,
                    onClick = { /*TODO*/ },
                    outerColor = Color(0xffF0F0F0),
                    innerColor = Color(0xffB4916C)
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomRadioButton(
                    selected = false,
                    onClick = { /*TODO*/ },
                    outerColor = Color(0xffE4CBAD),
                    innerColor = Color(0xffE4CBAD)
                )
            }
        }

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // Scrollable content
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 80.dp) // Padding to ensure content is not hidden by the fixed buttons
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = product.name,
                        fontFamily = FontFamily.Serif,
                        color = Color(0xff606060),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "$ ${product.price}",
                            fontFamily = FontFamily.Serif,
                            color = Color(0xff606060),
                            fontSize = 24.sp,
                            fontWeight = FontWeight(600)
                        )
                        SoluogCompose()
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.popular),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            tint = Color(0xffF2C94C)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "4.5 (50 reviews)",
                            fontFamily = FontFamily.Serif,
                            color = Color(0xff606060),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = product.description,
                        fontFamily = FontFamily.Serif,
                        color = Color(0xff606060),
                        fontSize = 16.sp
                    )
                }
            }

            // Fixed buttons
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(50.dp)
                        .background(
                            color = Color.Gray.copy(alpha = 0.2f),
                            shape = RoundedCornerShape(10.dp)
                        )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.marker),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                }

                Button(
                    onClick = {
                        navController.navigate("cart")
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xff242424)
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Add to cart",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreviewProduct() {
    // Fake product for preview
    val product = Product(
        name = "Minimal Stand",
        price = 50.0f,
        description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
        quantityStart = 5.0f,
        img = R.drawable.image_product2
    )
    ProductDetailScreen(navController = NavController(context = LocalContext.current), product = product)
}

@Composable
fun CustomRadioButton(
    selected: Boolean,
    onClick: () -> Unit,
    outerColor: Color,
    innerColor: Color
) {
    Box(
        modifier = Modifier
            .size(24.dp)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        // Outer circle
        Box(
            modifier = Modifier
                .size(20.dp)
                .background(color = outerColor, shape = RoundedCornerShape(10.dp))
        )
        // Inner circle
        if (selected) {
            Box(
                modifier = Modifier
                    .size(15.dp)
                    .background(color = innerColor, shape = CircleShape)
            )
        }
    }
}