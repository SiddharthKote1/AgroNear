package com.sid.agronear.Screens

import android.content.pm.PackageManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutAppScreen(navController: NavController) {
    val context = LocalContext.current
    val versionName = try {
        val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
        packageInfo.versionName
    } catch (e: PackageManager.NameNotFoundException) {
        "Unknown"
    }

    val config = LocalConfiguration.current
    val scaleW = config.screenWidthDp / 411f
    val scaleH = config.screenHeightDp / 891f

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE8F5E9))
    ) {
        // ✅ Header Section (consistent with Notification/Profile screens)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height((140 * scaleH).dp)
                .clip(
                    RoundedCornerShape(
                        bottomStart = (80 * scaleW).dp,
                        bottomEnd = (80 * scaleW).dp
                    )
                )
                .background(Color(0xFF98FB98))
        ) {
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = (40 * scaleH).dp, start = (16 * scaleW).dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }

            Text(
                text = "About App",
                color = Color.White,
                fontSize = (22 * scaleW).sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        // ✅ Main Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = (160 * scaleH).dp, start = (20 * scaleW).dp, end = (20 * scaleW).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Info card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape((16 * scaleW).dp),
                elevation = CardDefaults.cardElevation((8 * scaleW).dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier.padding((20 * scaleW).dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        "About AgroNear",
                        fontSize = (20 * scaleW).sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF388E3C)
                    )
                    Spacer(modifier = Modifier.height((10 * scaleH).dp))

                    Text(
                        "Version: $versionName",
                        fontSize = (16 * scaleW).sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height((15 * scaleH).dp))

                    Text(
                        text = "AgroNear helps farmers and agri-enthusiasts connect, learn, and grow. " +
                                "We aim to make agriculture smarter, faster, and more accessible.",
                        fontSize = (15 * scaleW).sp,
                        color = Color.DarkGray,
                        textAlign = TextAlign.Start
                    )

                    Spacer(modifier = Modifier.height((20 * scaleH).dp))

                    Divider(color = Color(0xFFB0BEC5), thickness = 1.dp)

                    Spacer(modifier = Modifier.height((15 * scaleH).dp))

                    Text(
                        "Developed by: Siddharth Kote",
                        fontSize = (15 * scaleW).sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )
                    Text(
                        "Contact: siddharthkote128@gmail.com",
                        fontSize = (15 * scaleW).sp,
                        color = Color.Black
                    )
                }
            }
        }
    }
}

