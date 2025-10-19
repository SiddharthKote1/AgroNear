package com.sid.agronear.Screens

import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.sid.agronear.R
import com.sid.agronear.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageScreen(navController: NavController){

    val selectedLanguage = remember { mutableStateOf<String?>(null) }

    Box(modifier=Modifier.padding(top=20.dp)
        .background(Color(0xFFD9D9D9))) {
        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Row() {
                        Icon(
                            painterResource(R.drawable.langicon), contentDescription = null,
                            tint = Color.Unspecified,
                            modifier=Modifier.size(40.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Choose your Language",
                            color=Color.Black,
                            fontWeight = FontWeight.Bold)
                    }
                })
            }
        ) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                Row( horizontalArrangement = Arrangement.spacedBy(16.dp), // equal spacing
                    modifier = Modifier.padding(horizontal = 10.dp)) {
                    Card(
                        modifier = Modifier.padding(start = 10.dp)
                            .width(150.dp).height(60.dp)
                            .clickable { selectedLanguage.value = "English" }  // track selection
                            .border(
                                width = if (selectedLanguage.value == "English") 3.dp else 0.dp,
                                color = if (selectedLanguage.value == "English") Color.DarkGray else Color.Transparent,
                                shape = RoundedCornerShape(10.dp)),
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(
                            Color(0xFFEBF0A1)
                        )
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("English",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold)
                        }
                    }
                    Card(
                        modifier = Modifier.padding(start = 20.dp)
                            .width(150.dp).height(60.dp)
                            .clickable { selectedLanguage.value = "हिन्दी" }
                            .border(
                                width = if (selectedLanguage.value == "हिन्दी") 3.dp else 0.dp,
                                color = if (selectedLanguage.value == "हिन्दी") Color.DarkGray else Color.Transparent,
                                shape = RoundedCornerShape(10.dp)),
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(
                            Color(0xFF8DBDA1)
                        )
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("हिन्दी",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold)
                        }
                    }
                }
                Spacer(modifier=Modifier.padding(10.dp))
                Row( horizontalArrangement = Arrangement.spacedBy(16.dp), // equal spacing
                    modifier = Modifier.padding(horizontal = 10.dp)) {
                    Card(
                        modifier = Modifier.padding(start = 10.dp)
                            .width(150.dp).height(60.dp)
                            .clickable { selectedLanguage.value = "मराठी" }
                            .border(
                                width = if (selectedLanguage.value == "मराठी") 3.dp else 0.dp,
                                color = if (selectedLanguage.value == "मराठी") Color.DarkGray else Color.Transparent,
                                shape = RoundedCornerShape(10.dp)),
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(
                            Color(0xFF85CDDA)
                        )
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("मराठी",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold)
                        }
                    }
                    Card(
                        modifier = Modifier.padding(start = 20.dp)
                            .width(150.dp).height(60.dp)
                            .clickable { selectedLanguage.value = "বাংলা" }
                            .border(
                                width = if (selectedLanguage.value == "বাংলা") 3.dp else 0.dp,
                                color = if (selectedLanguage.value == "বাংলা") Color.DarkGray else Color.Transparent,
                                shape = RoundedCornerShape(10.dp)
                            ),
                        colors = CardDefaults.cardColors(
                            Color(0xFFD09981)
                        )
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("বাংলা",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold)
                        }
                    }
                }
                Spacer(modifier=Modifier.padding(10.dp))
                Row( horizontalArrangement = Arrangement.spacedBy(16.dp), // equal spacing
                    modifier = Modifier.padding(horizontal = 10.dp)) {
                    Card(
                        modifier = Modifier.padding(start = 10.dp)
                            .width(150.dp).height(60.dp)
                            .clickable { selectedLanguage.value = "தமிழ்" }
                            .border(
                                width = if (selectedLanguage.value == "தமிழ்") 3.dp else 0.dp,
                                color = if (selectedLanguage.value == "தமிழ்") Color.DarkGray else Color.Transparent,
                                shape = RoundedCornerShape(10.dp)
                            ),
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(
                            Color(0xFFEBF0A1)
                        )
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("தமிழ்",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold)
                        }
                    }
                    Card(
                        modifier = Modifier.padding(start = 20.dp)
                            .width(150.dp).height(60.dp)
                            .clickable { selectedLanguage.value = "తెలుగు" }
                            .border(
                                width = if (selectedLanguage.value == "తెలుగు") 3.dp else 0.dp,
                                color = if (selectedLanguage.value == "తెలుగు") Color.DarkGray else Color.Transparent,
                                shape = RoundedCornerShape(10.dp)
                            ),
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(
                            Color(0xFF8DBDA1)
                        )
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("తెలుగు",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold)
                        }
                    }
                }
                Spacer(modifier=Modifier.padding(10.dp))
                Row( horizontalArrangement = Arrangement.spacedBy(16.dp), // equal spacing
                    modifier = Modifier.padding(horizontal = 10.dp)) {
                    Card(
                        modifier = Modifier.padding(start = 10.dp)
                            .width(150.dp).height(60.dp)
                            .clickable { selectedLanguage.value = "ગુજરાતી" }
                            .border(
                                width = if (selectedLanguage.value == "ગુજરાતી") 3.dp else 0.dp,
                                color = if (selectedLanguage.value == "ગુજરાતી") Color.DarkGray else Color.Transparent,
                                shape = RoundedCornerShape(10.dp)
                            ),
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(
                            Color(0xFFD09981)
                        )
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("ગુજરાતી",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold
                                )
                        }
                    }
                    Card(
                        modifier = Modifier.padding(start = 20.dp)
                            .width(150.dp).height(60.dp)
                            .clickable { selectedLanguage.value = "ಕನ್ನಡ" }
                            .border(
                                width = if (selectedLanguage.value == "ಕನ್ನಡ") 3.dp else 0.dp,
                                color = if (selectedLanguage.value == "ಕನ್ನಡ") Color.DarkGray else Color.Transparent,
                                shape = RoundedCornerShape(10.dp)
                            ),
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(
                            Color(0xFF85CDDA)
                        )
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("ಕನ್ನಡ",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold)
                        }
                    }
                }
                Spacer(modifier=Modifier.padding(10.dp))
                Button(onClick={
                    navController.navigate(Routes.WelcomeScreem)
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
fun LanguageScreenPreview(){
    LanguageScreen(navController = NavHostController(context = LocalContext.current))
}