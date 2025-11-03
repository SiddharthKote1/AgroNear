package com.sid.agronear.Screens

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sid.agronear.R

@Composable
fun NotificationScreen(
    onBackClick: () -> Unit = {},
    navController: NavController
) {
    val context = LocalContext.current
    val config = LocalConfiguration.current
    val screenWidth = config.screenWidthDp
    val screenHeight = config.screenHeightDp
    val scaleW = screenWidth / 411f
    val scaleH = screenHeight / 891f

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE8F5E9))
    ) {
        // ✅ Header Section
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
                onClick = { onBackClick() },
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
                text = "Notifications",
                color = Color.White,
                fontSize = (22 * scaleW).sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height((24 * scaleH).dp))

        // ✅ Card 1 - App Updates
        NotificationItem(
            iconRes = R.drawable.updates,
            title = "App Updates",
            onClick = {
                Toast.makeText(context, "Checking for app updates...", Toast.LENGTH_SHORT).show()
                //Go to the playstore for apps update
            },
            scaleW = scaleW,
            scaleH = scaleH
        )

        // ✅ Card 2 - Permissions
        NotificationItem(
            iconRes = R.drawable.permission,
            title = "Permissions",
            onClick = {
                val intent = Intent(
                    Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                    //tells Android which page to open (the App Info screen).
                    Uri.parse("package:" + context.packageName)
                    //tells Android which app’s info to show — yours
                )
                intent.addCategory(Intent.CATEGORY_DEFAULT)
                //Adds a “default” label so Android knows this is a normal, safe action.
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                //Tells Android to open the Settings screen in a new window/task, not inside your app.
                context.startActivity(intent)
                //Executes the action — opens the App Info page.

                //Toast.makeText(context, "Opening permissions settings...", Toast.LENGTH_SHORT).show()
            },
            scaleW = scaleW,
            scaleH = scaleH
        )

        // ✅ Card 3 - Issues Mail
        NotificationItem(
            iconRes = R.drawable.mailus,
            title = "Issues? Mail us.",
            onClick = {
               // Toast.makeText(context, "Preparing to send email...", Toast.LENGTH_SHORT).show()
                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:") // Only email apps should handle this
                        putExtra(Intent.EXTRA_EMAIL, arrayOf("support@agronear.com"))
                        putExtra(Intent.EXTRA_SUBJECT, "Issue Report - AgroNear App")
                        putExtra(Intent.EXTRA_TEXT, "Hi AgroNear Team,\n\nI encountered an issue in the app:\n\n[Describe your issue here]\n\nThanks,")
                    }

                    try {
                        context.startActivity(intent)
                    } catch (e: Exception) {
                        Toast.makeText(context, "No email app found.", Toast.LENGTH_SHORT).show()
                    }
            },
            scaleW = scaleW,
            scaleH = scaleH
        )
    }
}

@Composable
fun NotificationItem(
    iconRes: Int,
    title: String,
    onClick: () -> Unit,
    scaleW: Float,
    scaleH: Float
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = (20 * scaleW).dp, vertical = (8 * scaleH).dp)
            .clickable { onClick() },
        shape = RoundedCornerShape((12 * scaleW).dp),
        elevation = CardDefaults.cardElevation((6 * scaleW).dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding((16 * scaleW).dp)
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.size((28 * scaleW).dp)
            )
            Spacer(modifier = Modifier.width((12 * scaleW).dp))
            Text(
                text = title,
                fontSize = (16 * scaleW).sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationScreenPreview() {
    NotificationScreen(navController = rememberNavController())
}
