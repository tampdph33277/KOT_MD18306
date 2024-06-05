package com.example.roomdb


import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import java.util.Objects
import kotlin.math.log

@Composable
fun GetLayoutUpdateStudent(navController: NavHostController, id: Int?) {
    var context = LocalContext.current
    val db = Room.databaseBuilder(
        context,
        StudentDB::class.java,
        "student"
    ).allowMainThreadQueries().build()

    var st: StudentModel? = null
    fun getStudent() {
        if (id != null) {
            st = db.studentDAO().getId(id)
        }
    }
    getStudent()
    Log.d("zzzzzzz", "GetLayoutUpdateStudent: ${st!!.hoTen}")

    var nameSv by remember {
        mutableStateOf(st?.hoTen ?: "")
    }

    var maSv by remember {
        mutableStateOf(st?.maSv ?: "")
    }

    var diemTb by remember {
        mutableStateOf(st?.diemTB?.toString() ?: "")
    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Sửa Thông tin SV $id",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Serif
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = nameSv,
            onValueChange = {
                nameSv = it
            },
            placeholder = {
                Text(
                    text = "Tên Sinh Viên",
                    fontFamily = FontFamily.Serif,
                )
            },
            textStyle = TextStyle(
                fontFamily = FontFamily.Serif
            ),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 3.dp,
                    shape = RoundedCornerShape(8.dp)
                ),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = maSv,
            onValueChange = {
                maSv = it
            },
            placeholder = {
                Text(
                    text = "Mã Sinh Viên",
                    fontFamily = FontFamily.Serif,
                )
            },
            textStyle = TextStyle(
                fontFamily = FontFamily.Serif
            ),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 3.dp,
                    shape = RoundedCornerShape(8.dp)
                ),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = diemTb,
            onValueChange = {
                diemTb = it
            },
            placeholder = {
                Text(
                    text = "Điểm",
                    fontFamily = FontFamily.Serif,
                )
            },
            textStyle = TextStyle(
                fontFamily = FontFamily.Serif
            ),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 3.dp,
                    shape = RoundedCornerShape(8.dp)
                ),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                if (
                    nameSv.isNotBlank()
                    && maSv.isNotBlank()
                    && diemTb.isNotBlank()
                ) {
                    st?.let {
                        it.hoTen = nameSv
                        it.maSv = maSv
                        it.diemTB = diemTb.toFloat()
                        db.studentDAO().update(it)
                        Toast.makeText(
                            context,
                            "Update student successfully",
                            Toast.LENGTH_SHORT
                        ).show()
                        navController.navigate(ROUTE.list.name) {
                            popUpTo(ROUTE.update.name) { inclusive = true }
                        }
                    }


                } else {
                    Toast.makeText(
                        context,
                        "Please enter information",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray
            )
        ) {
            Text(
                text = "Update",
                fontFamily = FontFamily.Serif
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Quay lại danh sách",
            fontFamily = FontFamily.Serif,
            modifier = Modifier.selectable(
                selected = true,
                onClick = {
                    navController.navigate(ROUTE.list.name) {
                        popUpTo(ROUTE.insert.name) { inclusive = true }
                    }
                }
            )
        )
    }

}




@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingGetLayoutUpdateStudent() {
    GetLayoutUpdateStudent(
        navController = rememberNavController(),
        id = 0
    )
}