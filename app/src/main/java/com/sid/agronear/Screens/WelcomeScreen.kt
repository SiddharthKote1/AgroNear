package com.sid.agronear.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun WelcomeScreen(navController: NavController){
    Box(modifier=Modifier.fillMaxSize()
        .background(Color(0xFFD9D9D9))){
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(top = 120.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(R.drawable.farmerintro),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )

            Spacer(modifier = Modifier.height(80.dp))
            Column(modifier=Modifier.fillMaxSize()
                .padding(start = 10.dp, end = 10.dp),
                horizontalAlignment = Alignment.Start) {
                Text("Welcome to",
                    fontSize = 40.sp,
                    color=Color(0xFF00A11B),
                    fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(2.dp))
                Text("AgroNear",
                    fontSize = 40.sp,
                    color=Color(0xFF00A11B),
                    fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(60.dp))
                Text("“Connecting farmers and buyers in your neighborhood.",
                    color=Color.Black,
                    fontWeight=FontWeight.Bold,
                    fontSize = 18.sp)
                Spacer(modifier=Modifier.height(40.dp))
                Button(onClick={
                     navController.navigate(Routes.SelectionScreen)
                },
                    modifier=Modifier.fillMaxWidth()
                        .padding(10.dp)
                        .width(45.dp).height(45.dp),
                    shape=RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF00A11B) ,
                        contentColor= Color.Black
                    )){
                    Text("Continue",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun WelcomeScreenPreview(){
    WelcomeScreen(navController = NavController(context = LocalContext.current))
}