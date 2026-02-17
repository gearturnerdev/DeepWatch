package dev.gearturner.deepwatch.navigation

import androidx.navigation.compose.composable
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dev.gearturner.deepwatch.screens.DailySurvey
import dev.gearturner.deepwatch.screens.MainScreen
import dev.gearturner.deepwatch.screens.SubmittedScreen
import dev.gearturner.deepwatch.screens.WeeklySurvey
import dev.gearturner.deepwatch.screens.UsageCategoryScreen
import dev.gearturner.deepwatch.screens.UsageListScreen
import dev.gearturner.deepwatch.screens.UsagePermissionScreen
import dev.gearturner.deepwatch.screens.usage.hasUsagePermission

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") {MainScreen(navController)}
        composable("weekly") {WeeklySurvey(navController)}
        composable("daily") { DailySurvey(navController) }
        composable("usage_categories") {UsageCategoryScreen(navController)}
        composable("usage") {UsageListScreen()}
        composable("usage_permission") {UsagePermissionScreen()}
        composable("submitted"){ SubmittedScreen(navController) }
    }
}