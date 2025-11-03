package com.sid.agronear.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sid.agronear.R
import com.sid.agronear.Routes

@Composable
fun WelcomeScreen(navController: NavController) {

    // ✅ Get screen height and width for proportional scaling
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE8F5E9))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = screenHeight * 0.15f), // 15% from top (dynamic)
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // ✅ Image scales with screen width
            Image(
                painter = painterResource(R.drawable.farmerintro),
                contentDescription = null,
                modifier = Modifier
                    .width(screenWidth * 0.55f) // 55% of screen width
                    .aspectRatio(1f) // keeps it square
            )

            Spacer(modifier = Modifier.height(screenHeight * 0.1f))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = screenWidth * 0.05f), // 5% horizontal padding
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    "Welcome to",
                    fontSize = (screenWidth.value * 0.08).sp, // scales text
                    color = Color(0xFF00A11B),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    "AgroNear",
                    fontSize = (screenWidth.value * 0.08).sp,
                    color = Color(0xFF00A11B),
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(screenHeight * 0.05f))

                Text(
                    "“Connecting farmers and buyers in your neighborhood.”",
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    fontSize = (screenWidth.value * 0.045).sp // adjusts automatically
                )

                Spacer(modifier = Modifier.height(screenHeight * 0.05f))

                // ✅ Responsive Button
                Button(
                    onClick = {
                        navController.navigate(Routes.SelectionScreen)
                    },
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .height(screenHeight * 0.06f), // 7% of screen height
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF00A11B),
                        contentColor = Color.Black
                    )
                ) {
                    Text(
                        "Continue",
                        fontSize = (screenWidth.value * 0.04).sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(navController = NavController(context = LocalContext.current))
}


