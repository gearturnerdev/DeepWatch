package dev.gearturner.deepwatch.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import dev.gearturner.deepwatch.screens.usage.UsageViewModel


@Composable
fun UsageCategoryScreen(
    navController: NavHostController,
    viewModel: UsageViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.loadUsage()
    }

    val categories by viewModel.categoryUsage.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(categories) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = item.category.name.replace("_", " "))
                Text(text = "${item.totalMinutes} min")
            }
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    navController.navigate("usage")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Show details")
            }
        }
    }
}
