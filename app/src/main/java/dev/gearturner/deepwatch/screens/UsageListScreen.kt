package dev.gearturner.deepwatch.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import dev.gearturner.deepwatch.screens.usage.UsageViewModel

@Composable
fun UsageListScreen(viewModel: UsageViewModel = viewModel()) {

    LaunchedEffect(Unit) {
        viewModel.loadUsage()
    }

    val usageList by viewModel.usageList.collectAsState()

    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(usageList) { app ->
            Column(modifier = Modifier.padding(vertical = 8.dp)) {
                Text(text = app.appName)
                Text(text = "Usage: ${app.usageMinutes} min")
            }
        }
    }
}