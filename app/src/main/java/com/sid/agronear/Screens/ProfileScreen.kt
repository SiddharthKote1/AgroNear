package com.sid.agronear.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sid.agronear.R
import com.sid.agronear.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {

    val config = LocalConfiguration.current
    val scaleW = config.screenWidthDp / 411f
    val scaleH = config.screenHeightDp / 891f

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE8F5E9))
    ) {
        // ✅ Header same as Notification screen
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
                .background(Color(0xFF66BB6A))
        ) {
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = (40 * scaleH).dp, start = (16 * scaleW).dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }

            Text(
                text = "Profile",
                color = Color.White,
                fontSize = (22 * scaleW).sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        // 🧍‍♂️ Main content (unchanged)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = (160 * scaleH).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile picture",
                modifier = Modifier
                    .size((80 * scaleW).dp)
                    .clip(CircleShape)
                    .background(Color(0xFFB0C4DE)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height((10 * scaleH).dp))

            Text(
                text = "Name",
                fontSize = (18 * scaleW).sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Occupation",
                fontSize = (14 * scaleW).sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height((25 * scaleH).dp))

            Box(
                modifier = Modifier
                    .background(Color(0xFF4A4A4A), RoundedCornerShape((12 * scaleW).dp))
                    .padding((16 * scaleW).dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy((12 * scaleH).dp)) {
                    ProfileOption(
                        icon = Icons.Default.Settings,
                        text = "Settings",
                        scaleW = scaleW,
                        onClick = { navController.navigate(Routes.SettingsScreen) }
                    )
                    ProfileOption(
                        icon = Icons.Default.Notifications,
                        text = "Notifications",
                        scaleW = scaleW,
                        onClick = { navController.navigate(Routes.NotificationScreen) }
                    )
                    ProfileOption(
                        icon = Icons.Default.ExitToApp,
                        text = "Logout",
                        scaleW = scaleW,
                        onClick = {}
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileOption(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    text: String,
    scaleW: Float,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .clip(RoundedCornerShape((10 * scaleW).dp))
            .background(Color(0xFFEFEFEF))
            .clickable { onClick() }
            .padding(horizontal = (16 * scaleW).dp, vertical = (10 * scaleW).dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = Color(0xFF00BFFF),
            modifier = Modifier.size((20 * scaleW).dp)
        )
        Spacer(modifier = Modifier.width((12 * scaleW).dp))
        Text(
            text = text,
            fontSize = (15 * scaleW).sp,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    ProfileScreen(navController = rememberNavController())
}

