package com.example.lab5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab5.ui.theme.Lab5Theme

class Bai1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            layoutLab5Bai1()
        }
    }
}

@Preview(widthDp = 500, heightDp = 900)
@Composable
fun layoutLab5Bai1() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(false) }
    var showAlert by remember { mutableStateOf(false) }
    var alertMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Logo
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Logo"
        )
        Spacer(modifier = Modifier.height(20.dp))

        // Username TextField
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Password TextField
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Save Password Switch
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Switch(
                checked = isChecked,
                onCheckedChange = {
                    isChecked = it
                    if (it) {
                        alertMessage = "Lưu mật khẩu thành công"
                        showAlert = true
                    }
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.Green,
                    uncheckedThumbColor = Color.Gray,
                    checkedTrackColor = Color.Green.copy(alpha = 0.5f),
                    uncheckedTrackColor = Color.Gray.copy(alpha = 0.5f)
                ),
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = "Lưu mật khẩu?",
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Login Button
        Button(
            onClick = {
                if (username.isNotBlank() && password.isNotBlank()) {
                    alertMessage = "Login successful"
                } else {
                    alertMessage = "Please enter username and password"
                }
                showAlert = true
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray,
                contentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }
    }

    if (showAlert) {
        AlertDialog(
            onDismissRequest = { showAlert = false },
            title = { Text("Thông báo") },
            text = { Text(alertMessage) },
            confirmButton = {
                TextButton(onClick = { showAlert = false }) {
                    Text("OK")
                }
            }
        )
    }
}