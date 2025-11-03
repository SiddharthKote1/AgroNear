package com.sid.agronear.Screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sid.agronear.R
import com.sid.agronear.Routes

@Composable
fun SelectionScreen(navController: NavController) {
    val selectedRole = remember { mutableStateOf<String?>(null) }

    // 👇 scaling based on screen width/height
    val config = LocalConfiguration.current
    val screenWidth = config.screenWidthDp
    val screenHeight = config.screenHeightDp
    val scaleW = screenWidth / 411f
    val scaleH = screenHeight / 891f
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE8F5E9))
    ) {
        Column(
            modifier = Modifier.padding(top = (60 * scaleH).dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "How do You want to use the app",
                color = Color.Black,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                fontSize = (24 * scaleW).sp,
                modifier = Modifier.padding(horizontal = (12 * scaleW).dp)
            )

            Spacer(modifier = Modifier.height((10 * scaleH).dp))

            Text(
                "Select the role to get Started",
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                fontSize = (18 * scaleW).sp
            )

            Spacer(modifier = Modifier.height((40 * scaleH).dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = (10 * scaleW).dp),
            ) {
                // ---- Farmer Card ----
                Card(
                    modifier = Modifier
                        .width((screenWidth * 0.4f).dp)
                        .height((screenHeight * 0.32f).dp)
                        .clickable { selectedRole.value = "Farmer" }
                        .then(
                            if (selectedRole.value == "Farmer")
                                Modifier.border(
                                    (2 * scaleW).dp,
                                    Color(0xFF00A11B),
                                    RoundedCornerShape((10 * scaleW).dp)
                                )
                            else Modifier
                        ),
                    shape = RoundedCornerShape((10 * scaleW).dp),
                    colors = CardDefaults.cardColors(Color(0xFFEBF0A1))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding((10 * scaleW).dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            "Register as Farmer",
                            fontSize = (17 * scaleW).sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )

                        Image(
                            painter = painterResource(R.drawable.farming),
                            contentDescription = null,
                            modifier = Modifier.size((screenWidth * 0.25f).dp)
                        )

                        Text(
                            text = "Sell your products directly\nto buyers.",
                            fontSize = (12 * scaleW).sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                // ---- Buyer Card ----
                Card(
                    modifier = Modifier
                        .width((screenWidth * 0.4f).dp)
                        .height((screenHeight * 0.32f).dp)
                        .clickable { selectedRole.value = "Buyer" }
                        .then(
                            if (selectedRole.value == "Buyer")
                                Modifier.border(
                                    (2 * scaleW).dp,
                                    Color(0xFF00A11B),
                                    RoundedCornerShape((10 * scaleW).dp)
                                )
                            else Modifier
                        ),
                    shape = RoundedCornerShape((10 * scaleW).dp),
                    colors = CardDefaults.cardColors(Color(0xFFEBF0A1))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding((10 * scaleW).dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            "Register as Buyer",
                            fontSize = (17 * scaleW).sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )

                        Image(
                            painter = painterResource(R.drawable.buyer),
                            contentDescription = null,
                            modifier = Modifier.size((screenWidth * 0.25f).dp)
                        )

                        Text(
                            "Buy farm-fresh products\ndirectly from farmers.",
                            fontSize = (12 * scaleW).sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height((25 * scaleH).dp))

            Button(
                onClick = {
                    if (selectedRole.value != null) {
                        // You can pass the selected role to the next screen using arguments if needed
                        navController.navigate(Routes.LoginScreen)
                    } else {
                        Toast.makeText(context, "Please select a role to continue", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = (20 * scaleW).dp)
                    .height((50 * scaleH).dp),
                shape = RoundedCornerShape((10 * scaleW).dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00A11B),
                    contentColor = Color.Black
                )
            ) {
                Text(
                    "Continue",
                    fontSize = (18 * scaleW).sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SelectionScreenPreview() {
    SelectionScreen(navController = NavController(context = LocalContext.current))
}

