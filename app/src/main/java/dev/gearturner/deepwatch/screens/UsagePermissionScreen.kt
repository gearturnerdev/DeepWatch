package dev.gearturner.deepwatch.screens

import android.content.Intent
import android.provider.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController

@Composable
fun UsagePermissionScreen() {
    val context = LocalContext.current

    Button(onClick = {
        val intent = Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS)
        context.startActivity(intent)
    }) {
        Text(text = "Enable Usage Access")
    }
}
