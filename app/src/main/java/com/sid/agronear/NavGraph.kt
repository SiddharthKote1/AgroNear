package com.sid.agronear

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sid.agronear.Routes.MainScreen
import com.sid.agronear.Screens.AboutAppScreen
import com.sid.agronear.Screens.LoginScreen
import com.sid.agronear.Screens.MainScreen
import com.sid.agronear.Screens.NotificationScreen
import com.sid.agronear.Screens.ProfileScreen
import com.sid.agronear.Screens.SelectionScreen
import com.sid.agronear.Screens.SettingsScreen
import com.sid.agronear.Screens.SignupScreen
import com.sid.agronear.Screens.WelcomeScreen


@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.WelcomeScreem
    ) {
        composable(Routes.WelcomeScreem) {
            WelcomeScreen(navController = navController)
        }
        composable(Routes.LoginScreen) {
            LoginScreen(navController = navController)
        }
        composable(Routes.SignupScreen){
            SignupScreen(navController=navController)
        }
        composable(Routes.SelectionScreen){
            SelectionScreen(navController=navController)
        }
        composable(Routes.NotificationScreen){
            NotificationScreen(navController=navController)
        }
        composable(Routes.ProfileScreen){
            ProfileScreen(navController=navController)
        }
        composable(Routes.AboutAppScreen){
            AboutAppScreen(navController=navController)
        }
        composable(Routes.SettingsScreen){
            SettingsScreen(navController=navController)
        }
        composable(Routes.MainScreen) {
            MainScreen(navController = navController)
        }
    }
}