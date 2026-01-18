package com.sid.agronear

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sid.agronear.Screens.AboutAppScreen
import com.sid.agronear.Screens.AddProductScreen
import com.sid.agronear.Screens.LoginScreen
import com.sid.agronear.Screens.MainAppScreen
import com.sid.agronear.Screens.MyProductsScreen
import com.sid.agronear.Screens.NotificationScreen
import com.sid.agronear.Screens.ProductDetailScreen
import com.sid.agronear.Screens.ProfileScreen
import com.sid.agronear.Screens.SelectionScreen
import com.sid.agronear.Screens.SettingsScreen
import com.sid.agronear.Screens.SignupScreen
import com.sid.agronear.Screens.WelcomeScreen
import com.sid.agronear.ui.bottombar.BottomBar


@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute in listOf(
                    Routes.MainAppScreen,
                    Routes.MyProductsScreen,
                    Routes.ProfileScreen
                )
            ) {
                BottomBar(navController)
            }
        }
    ) { paddingValues ->

    NavHost(
        navController = navController,
        startDestination = Routes.WelcomeScreem,
        modifier=Modifier.padding(paddingValues)
    ) {
        composable(Routes.WelcomeScreem) {
            WelcomeScreen(navController = navController)
        }
        composable(Routes.LoginScreen) {
            LoginScreen(navController = navController)
        }
        composable(Routes.SignupScreen) {
            SignupScreen(navController = navController)
        }
        composable(Routes.SelectionScreen) {
            SelectionScreen(navController = navController)
        }
        composable(Routes.NotificationScreen) {
            NotificationScreen(navController = navController)
        }
        composable(Routes.ProfileScreen) {
            ProfileScreen(navController = navController)
        }
        composable(Routes.AboutAppScreen) {
            AboutAppScreen(navController = navController)
        }
        composable(Routes.SettingsScreen) {
            SettingsScreen(navController = navController)
        }
        composable(Routes.MainAppScreen) {
            MainAppScreen(navController = navController)
        }

        composable(Routes.MyProductsScreen) {
            MyProductsScreen(navController = navController)
        }
        composable(Routes.AddProductScreen) {
            AddProductScreen(navController = navController)
        }
        composable(
            route = "${Routes.ProductDetailScreen}/{productId}"
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")?.toLongOrNull()
            ProductDetailScreen(
                navController = navController,
                productId = productId
            )
        }
    }
    }
}

val bottomBarRoutes = listOf(
    Routes.MainAppScreen,
    Routes.MyProductsScreen,
    Routes.ProfileScreen
)