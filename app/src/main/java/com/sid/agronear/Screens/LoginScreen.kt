package com.sid.agronear.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sid.agronear.R
import com.sid.agronear.Routes
import com.sid.agronear.Screens.viewmodel.LoginViewModel

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val viewModel: LoginViewModel = viewModel()
    val config = LocalConfiguration.current
    val screenWidth = config.screenWidthDp
    val screenHeight = config.screenHeightDp
    val scaleW = screenWidth / 411f
    val scaleH = screenHeight / 891f
    var passwordVisible by remember { mutableStateOf(false) }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE8F5E9))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = (30 * scaleW).dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height((20 * scaleH).dp))

            Image(
                painter = painterResource(R.drawable.login),
                contentDescription = null,
                modifier = Modifier.size((250 * scaleW).dp)
            )

            Spacer(modifier = Modifier.height((20 * scaleH).dp))

            // 🔹 Login Card
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF4A4A4A),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape((12 * scaleW).dp),
                elevation = CardDefaults.cardElevation(defaultElevation = (6 * scaleW).dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = (20 * scaleW).dp,
                            vertical = (20 * scaleH).dp
                        ),
                    verticalArrangement = Arrangement.Top
                ) {
                    Text(
                        text = "Login Account",
                        fontSize = (30 * scaleW).sp,
                        fontWeight = FontWeight.Black,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height((20 * scaleH).dp))

                    // 🔹 Email Field
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        placeholder = {
                            Text("Email", color = Color.DarkGray, fontSize = (15 * scaleW).sp)
                        },
                        singleLine = true,
                        textStyle = LocalTextStyle.current.copy(fontSize = (14 * scaleW).sp),
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape((10 * scaleW).dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color(0xFFD9D9D9),
                            unfocusedContainerColor = Color(0xFFD9D9D9),
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black,
                            focusedIndicatorColor = Color.Black,
                            unfocusedIndicatorColor = Color.Gray
                        )
                    )

                    Spacer(modifier = Modifier.height((12 * scaleH).dp))

                    // 🔹 Password Field
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        placeholder = {
                            Text("Password", color = Color.DarkGray, fontSize = (15 * scaleW).sp)
                        },
                    singleLine = true,
                        textStyle = LocalTextStyle.current.copy(fontSize = (14 * scaleW).sp),
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape((10 * scaleW).dp),
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            val iconRes = if (passwordVisible) R.drawable.visible else R.drawable.hide
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(
                                    painter = painterResource(id = iconRes),
                                    contentDescription = if (passwordVisible) "Hide password" else "Show password",
                                    tint = Color.Black,
                                    modifier=Modifier.size(22.dp)
                                )
                            }
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color(0xFFD9D9D9),
                            unfocusedContainerColor = Color(0xFFD9D9D9),
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black,
                            focusedIndicatorColor = Color.Black,
                            unfocusedIndicatorColor = Color.Gray
                        )
                    )

                    Spacer(modifier = Modifier.height((20 * scaleH).dp))

                    // 🔹 Recover Password Row
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height((24 * scaleH).dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Don't remember password? ",
                            color = Color.White,
                            fontSize = (13 * scaleW).sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        )

                        TextButton(
                            onClick = { /* TODO: Navigate to password recovery screen */ },
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Text(
                                text = "Recover it",
                                color=Color.White,
                                fontSize = (13 * scaleW).sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    // 🔹 Signup Row
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height((24 * scaleH).dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Don't have an account?",
                            color = Color.White,
                            fontSize = (13 * scaleW).sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        )

                        TextButton(
                            onClick = { navController.navigate(Routes.SignupScreen) },
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Text(
                                text = "Sign up",
                                color=Color.White,
                                fontSize = (13 * scaleW).sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height((20 * scaleH).dp))

            // 🔹 Login Button (aligned with Card)
            Button(
                onClick = {
                    viewModel.login(
                        email = email,
                        password = password
                    ) {
                        navController.navigate(Routes.MainScreen) {
                            popUpTo(Routes.LoginScreen) { inclusive = true }
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height((48 * scaleH).dp),
                shape = RoundedCornerShape((10 * scaleW).dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00A11B),
                    contentColor = Color.Black
                )
            ) {
                if (viewModel.isLoading) {
                    CircularProgressIndicator(
                        color = Color.Black,
                        strokeWidth = 2.dp,
                        modifier = Modifier.size(22.dp)
                    )
                } else {
                    Text(
                        text = "Login",
                        fontSize = (20 * scaleW).sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun LoginScreenPreview() {
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}
