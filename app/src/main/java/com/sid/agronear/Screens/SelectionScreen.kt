package com.sid.agronear.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionContext
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
fun SelectionScreen(navController: NavController) {
    val selectedRole = remember { mutableStateOf<String?>(null) }

    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color(0xFFD9D9D9))
    ) {
        Column(
            modifier = Modifier.padding(top = 60.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "How do You want to use the app",
                color = Color.Black,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                modifier = Modifier.padding(12.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "Select the role to get Started",
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(45.dp),
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(40.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp), // equal spacing
                modifier = Modifier.padding(horizontal = 10.dp),
            ) {
                Card(
                    modifier = Modifier.padding(start = 10.dp)
                        .width(170.dp).height(300.dp)
                        .clickable { selectedRole.value = "Farmer" }
                        .then(
                            if (selectedRole.value == "Farmer")
                                Modifier.border(2.dp, Color(0xFF00A11B), RoundedCornerShape(10.dp))
                            else Modifier
                        ),
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(
                        Color(0xFFEBF0A1)
                    )
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            "1.Register as Farmer",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier=Modifier.padding(top=5.dp)
                        )

                        Spacer(modifier=Modifier.height(5.dp))

                        Image(
                            painter = painterResource(R.drawable.farming),
                            contentDescription = null,
                            modifier = Modifier.size(200.dp)
                        )

                        Text(
                            text = "Select the option if you want \n" +
                                    "to sell the product to the \n" +
                                    "the buyers",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 5.dp,start = 5.dp),
                            textAlign = TextAlign.Justify
                        )

                    }
                }
                Card(
                    modifier = Modifier.padding(start = 10.dp)
                        .width(170.dp).height(300.dp)
                        .clickable { selectedRole.value = "Buyer" }
                        .then(
                            if (selectedRole.value == "Buyer")
                                Modifier.border(2.dp, Color(0xFF00A11B), RoundedCornerShape(10.dp))
                            else Modifier
                        ),
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(
                        Color(0xFFEBF0A1)
                    )
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            "2.Register as Buyer",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier=Modifier.padding(top=5.dp)
                        )
                       // Spacer(modifier=Modifier.height(5.dp))

                        Image(
                            painter = painterResource(R.drawable.buyer),
                            contentDescription = null,
                            modifier = Modifier.size(200.dp)
                        )

                        Text(
                            "Select the option if you want \n" +
                                    "buy the product direcly from \n" +
                                    "the farmers ",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            modifier=Modifier.padding(top=5.dp,start = 5.dp)
                        )
                    }
                }
            }
            Spacer(modifier=Modifier.height(20.dp))

            Button(onClick={
                navController.navigate(Routes.LoginScreen)
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



@Composable
@Preview(showBackground = true)
fun SelectionScreenPreview(){
    SelectionScreen(navController = NavController(context = LocalContext.current))
}