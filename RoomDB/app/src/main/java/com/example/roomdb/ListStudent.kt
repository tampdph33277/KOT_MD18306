package com.example.roomdb


import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.Navigator
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import androidx.room.Room

@Composable
fun GetLayoutHomeScreen(navController: NavHostController) {

    val content = LocalContext.current
    val db = Room.databaseBuilder(
        content,
        StudentDB::class.java,
        "student"
    ).allowMainThreadQueries().build()

    var list by remember {
        mutableStateOf(db.studentDAO().getAll())
    }
    var isShowDialog by remember {
        mutableStateOf(false)
    }
    var student by remember {
        mutableStateOf(StudentModel(0, "", "", 0f))
    }

    if (isShowDialog) {
        DialogCompose(
            onConfim = {
                db.studentDAO().delete(student)
                isShowDialog = false
                Toast.makeText(
                    content,
                    "Delete student successfully",
                    Toast.LENGTH_SHORT
                ).show()
                list = db.studentDAO().getAll()
            },
            onClose = { isShowDialog = false },
            title = "Thông báo !",
            mess = "Bạn có chắc chắn muốn xóa không?"
        )
    }



    Column {

        Text(
            text = "Danh sách sinh viên",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight(600),
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            textAlign = TextAlign.Center
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp, end = 10.dp)
        ) {
            LazyColumn {
                items(list) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .shadow(
                                elevation = 3.dp,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Row(
                            modifier = Modifier.weight(1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = it.uId.toString(),
                                fontFamily = FontFamily.Serif
                            )
                            Spacer(modifier = Modifier.width(20.dp))
                            Column(

                            ) {
                                Text(
                                    text = "Họ tên: ${it.hoTen}",
                                    fontFamily = FontFamily.Serif
                                )
                                Text(
                                    text = "MSV: ${it.maSv}",
                                    fontFamily = FontFamily.Serif
                                )
                                Text(
                                    text = "Diem: ${it.diemTB}",
                                    fontFamily = FontFamily.Serif
                                )
                            }
                        }
                        Row(
                            modifier = Modifier.weight(0.3f)
                        ) {
                            IconButton(onClick = {
                                navController.navigate(
                                    "${
                                        ROUTE.update
                                            .name
                                    }/${it.uId}"
                                )
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Edit,
                                    contentDescription = null
                                )
                            }
                            IconButton(onClick = {
                                isShowDialog = true
                                student.uId = it.uId
                                student.hoTen = it.hoTen
                                student.maSv = it.maSv
                                student.diemTB = it.diemTB

                            }) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = null
                                )
                            }
                        }
                    }
                }
            }

        }

    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(
            onClick = {
                navController.navigate(ROUTE.insert.name) {
                    popUpTo(ROUTE.list.name) { inclusive = true }
                }
            },
            containerColor = Color.Gray,
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingLayoutList() {
    GetLayoutHomeScreen(navController = rememberNavController())
}