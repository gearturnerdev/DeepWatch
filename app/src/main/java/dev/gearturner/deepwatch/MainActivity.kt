package dev.gearturner.deepwatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import dev.gearturner.deepwatch.navigation.AppNavigation
import dev.gearturner.deepwatch.screens.UsagePermissionScreen
import dev.gearturner.deepwatch.screens.usage.hasUsagePermission
import dev.gearturner.deepwatch.ui.theme.DeepWatchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            if(hasUsagePermission(this)){
                App()
            }
            else{
                UsagePermissionScreen()
            }
        }
    }
}

@Composable
fun App() {
    DeepWatchTheme {
        AppNavigation()
    }
}
