package com.sid.agronear.Screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sid.agronear.R
import com.sid.agronear.Routes
import com.sid.agronear.viewmodel.AuthViewModel
@Composable
fun SignupScreen(navController: NavController) {
    val authViewModel: AuthViewModel = viewModel()


    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rePassword by remember { mutableStateOf("") }

    val signupSuccess by authViewModel.loginSuccess.observeAsState()
    val error by authViewModel.error.observeAsState()

    var passwordVisible by remember { mutableStateOf(false) }
    var rePasswordVisible by remember { mutableStateOf(false) }

    val config = LocalConfiguration.current
    val screenWidth = config.screenWidthDp
    val screenHeight = config.screenHeightDp
    val scaleW = screenWidth / 411f
    val scaleH = screenHeight / 891f


    LaunchedEffect(signupSuccess) {
        if (signupSuccess == true) {
            navController.navigate(Routes.LoginScreen) {
                popUpTo(Routes.SignupScreen) { inclusive = true }
            }
        }
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE8F5E9))
    ) {
        Column(
            modifier = Modifier
                .padding((15 * scaleW).dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(R.drawable.singup),
                contentDescription = null,
                modifier = Modifier.size((250 * scaleW).dp)
            )

            Spacer(modifier = Modifier.height((20 * scaleH).dp))

            Box(modifier = Modifier.padding((30 * scaleW).dp)) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height((425 * scaleH).dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF4A4A4A),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape((12 * scaleW).dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = (6 * scaleW).dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                start = (20 * scaleW).dp,
                                top = (20 * scaleH).dp,
                                end = (20 * scaleW).dp
                            ),
                        verticalArrangement = Arrangement.Top
                    ) {
                        Text(
                            text = "Signup Account",
                            fontSize = (30 * scaleW).sp,
                            fontWeight = FontWeight.Black,
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.height((20 * scaleH).dp))

                        OutlinedTextField(
                            value = name,
                            onValueChange = { name = it },
                            label = { Text("Name", color = Color.Black) },
                            placeholder = { Text("Enter your Name") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape((10 * scaleW).dp),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color(0xFFD9D9D9),
                                unfocusedContainerColor = Color(0xFFD9D9D9),
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Black,
                                focusedLabelColor = Color.Black,
                                unfocusedLabelColor = Color.DarkGray,
                                focusedIndicatorColor = Color.Black,
                                unfocusedIndicatorColor = Color.Gray
                            )
                        )

                        Spacer(modifier = Modifier.height((10 * scaleH).dp))

                        OutlinedTextField(
                            value = email, onValueChange = { email = it },
                            label = {
                                Text(
                                    "Email",
                                    color = Color.Black, fontSize =
                                        (15 * scaleW).sp
                                )
                            },
                            placeholder = { Text("Enter your Email") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape((10 * scaleW).dp),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color(0xFFD9D9D9),
                                unfocusedContainerColor = Color(0xFFD9D9D9),
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Black,
                                focusedLabelColor = Color.Black,
                                unfocusedLabelColor = Color.DarkGray,
                                focusedIndicatorColor = Color.Black,
                                unfocusedIndicatorColor = Color.Gray
                            )
                        )
                        Spacer(modifier = Modifier.height((10 * scaleH).dp))

                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            label = {
                                Text(
                                    "Password",
                                    color = Color.Black,
                                    fontSize = (15 * scaleW).sp
                                )
                            },
                            placeholder = { Text("Enter your password") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape((10 * scaleW).dp),
                            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            trailingIcon = {
                                val icon =
                                    if (passwordVisible) R.drawable.visible else R.drawable.hide
                                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                    Icon(
                                        painter = painterResource(id = icon),
                                        contentDescription = if (passwordVisible) "Hide password" else "Show password",
                                        tint = Color.Black,
                                        modifier = Modifier.size(22.dp)
                                    )
                                }
                            },
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color(0xFFD9D9D9),
                                unfocusedContainerColor = Color(0xFFD9D9D9),
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Black,
                                focusedLabelColor = Color.Black,
                                unfocusedLabelColor = Color.DarkGray,
                                focusedIndicatorColor = Color.Black,
                                unfocusedIndicatorColor = Color.Gray
                            )
                        )

                        Spacer(modifier = Modifier.height((10 * scaleH).dp))

                        OutlinedTextField(
                            value = rePassword,
                            onValueChange = { rePassword = it },
                            label = {
                                Text(
                                    "Re-Password",
                                    color = Color.Black,
                                    fontSize = (15 * scaleW).sp
                                )
                            },
                            placeholder = { Text("Re-enter your password") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape((10 * scaleW).dp),
                            visualTransformation = if (rePasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            trailingIcon = {
                                val iconRes =
                                    if (rePasswordVisible) R.drawable.visible else R.drawable.hide
                                IconButton(onClick = { rePasswordVisible = !rePasswordVisible }) {
                                    Icon(
                                        painter = painterResource(id = iconRes),
                                        contentDescription = if (rePasswordVisible) "Hide password" else "Show password",
                                        tint = Color.Black,
                                        modifier = Modifier.size(22.dp)
                                    )
                                }
                            },
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color(0xFFD9D9D9),
                                unfocusedContainerColor = Color(0xFFD9D9D9),
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Black,
                                focusedLabelColor = Color.Black,
                                unfocusedLabelColor = Color.DarkGray,
                                focusedIndicatorColor = Color.Black,
                                unfocusedIndicatorColor = Color.Gray
                            )
                        )


                        Spacer(modifier = Modifier.height((8 * scaleH).dp))
                    }
                }
            }

            Spacer(modifier = Modifier.height((20 * scaleH).dp))

            Button(
                onClick = {
                    if (password == rePassword) {
                        authViewModel.register(name, email, password)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = (30 * scaleW).dp)
                    .height((48 * scaleH).dp),
                shape = RoundedCornerShape((10 * scaleW).dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00A11B),
                    contentColor = Color.Black
                )
            ) {
                Text(
                    text = "Signup",
                    fontSize = (20 * scaleW).sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun SignupScreenPreview() {
    val navController = rememberNavController()
    SignupScreen(navController = navController)
}