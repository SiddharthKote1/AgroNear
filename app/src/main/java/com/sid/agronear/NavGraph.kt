package com.sid.agronear

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sid.agronear.Screens.LanguageScreen


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
    }
}