package com.example.swasthasanchar.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.skydoves.landscapist.coil.CoilImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInPage(navController: NavController = rememberNavController()) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.White)
                .padding(top = 17.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Top bar with time and status icons
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom = 42.dp, start = 25.dp, end = 25.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    "9:40",
                    color = Color(0xFF221E1E),
                    fontSize = 16.sp
                )
                CoilImage(
                    imageModel = { "https://i.imgur.com/1tMFzp8.png" },
                    modifier = Modifier
                        .width(69.dp)
                        .height(11.dp)
                )
            }

            // Sign In Header
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom = 38.dp, start = 38.dp, end = 38.dp)
                    .fillMaxWidth()
            ) {
                CoilImage(
                    imageModel = { "https://i.imgur.com/1tMFzp8.png" },
                    modifier = Modifier
                        .padding(end = 88.dp)
                        .width(24.dp)
                        .height(24.dp)
                )
                Text(
                    "Sign In",
                    color = Color(0xFF221F1F),
                    fontSize = 18.sp
                )
            }

            // Email Input
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Enter your email") },
                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .fillMaxWidth()
                    .padding(bottom = 25.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0x1A221F1F),
                    focusedBorderColor = Color(0xFF407CE2)
                ),
                shape = RoundedCornerShape(6.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            // Password Input
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0x1A221F1F),
                    focusedBorderColor = Color(0xFF407CE2)
                ),
                shape = RoundedCornerShape(6.dp),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            // Forgot Password Link
            Text(
                "Forgot password?",
                color = Color(0xFF407CE2),
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(bottom = 50.dp, start = 36.dp, end = 36.dp)
                    .clickable { /* Handle forgot password */ }
            )

            // Sign In Button
            Button(
                onClick = { navController.navigate("home") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF407CE2)),
                modifier = Modifier
                    .padding(bottom = 14.dp, start = 30.dp, end = 30.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(32.dp)
            ) {
                Text(
                    "Sign In",
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }

            // Sign Up Link
            Text(
                "Don't have an account? Sign up",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 52.dp)
                    .fillMaxWidth()
                    .clickable { navController.navigate("registration") }
            )

            // OR Divider
            Row(
                modifier = Modifier
                    .padding(horizontal = 30.dp, vertical = 25.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(
                    color = Color(0x1A221F1F),
                    modifier = Modifier
                        .weight(1f)
                )
                Text(
                    "OR",
                    color = Color(0xFFA0A7B0),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Divider(
                    color = Color(0x1A221F1F),
                    modifier = Modifier
                        .weight(1f)
                )
            }

            // Google Sign In Button
            OutlinedButton(
                onClick = { /* Handle Google sign in */ },
                border = BorderStroke(1.dp, Color(0xFFE5E7EB)),
                colors = ButtonDefaults.outlinedButtonColors(),
                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(vertical = 12.dp)
                ) {
                    CoilImage(
                        imageModel = { "https://i.imgur.com/1tMFzp8.png" },
                        modifier = Modifier
                            .padding(end = 26.dp)
                            .size(20.dp)
                    )
                    Text(
                        "Sign in with Google",
                        color = Color(0xFF221F1F),
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}