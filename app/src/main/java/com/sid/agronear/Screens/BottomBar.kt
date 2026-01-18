package com.sid.agronear.ui.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.Person2
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.sid.agronear.Routes
import com.sid.agronear.Screens.bottomBarItems

@Composable
fun BottomBar(navController: NavController) {

    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 4.dp
    ) {

        NavigationBarItem(
            selected = currentRoute(navController) == Routes.MainAppScreen,
            onClick = {
                navController.navigate(Routes.MainAppScreen) {
                    popUpTo(Routes.MainAppScreen) { inclusive = false }
                    launchSingleTop = true
                }
            },
            icon = {
                Icon(Icons.Default.Home, contentDescription = "Home")
            },
            label = { Text("Home") }
        )

        NavigationBarItem(
            selected = currentRoute(navController) == Routes.MyProductsScreen,
            onClick = {
                navController.navigate(Routes.MyProductsScreen) {
                    launchSingleTop = true
                }
            },
            icon = {
                Icon(Icons.Default.Inventory, contentDescription = "My Products")
            },
            label = { Text("My Products") }
        )

        NavigationBarItem(
            selected = currentRoute(navController) == Routes.ProfileScreen,
            onClick = {
                navController.navigate(Routes.ProfileScreen) {
                    launchSingleTop = true
                }
            },
            icon = {
                Icon(Icons.Default.Person2, contentDescription = "Profile")
            },
            label = { Text("Profile") }
        )
    }
}

@Composable
private fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}


