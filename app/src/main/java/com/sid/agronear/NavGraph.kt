package com.sid.agronear

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sid.agronear.Screens.LanguageScreen
import com.sid.agronear.Screens.LoginScreen
import com.sid.agronear.Screens.SelectionScreen
import com.sid.agronear.Screens.WelcomeScreen


@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.LanguageScreen
    ) {
        composable(Routes.LanguageScreen) {
                LanguageScreen(navController = navController)
            }
        composable(Routes.WelcomeScreem) {
            WelcomeScreen(navController = navController)
        }
        composable(Routes.SelectionScreen){
            SelectionScreen(navController=navController)
        }
        composable(Routes.LoginScreen) {
            LoginScreen(navController = navController)
        }
    }
}