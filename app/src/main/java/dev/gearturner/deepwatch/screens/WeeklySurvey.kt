package dev.gearturner.deepwatch.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import dev.gearturner.deepwatch.saveData.saveSliderValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlin.math.roundToInt

@Composable
fun WeeklySurvey(navController: NavHostController) {
    var sliderValues = remember {
        mutableStateListOf(5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f)
    }
    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 96.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(96.dp)
    ) {
        item {
            Text(
                text = "In the past week...",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                lineHeight = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }
        item {
            Text(
                text = "How often have you been upset because of something that happened unexpectedly?",
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Slider(
                value = sliderValues[0],
                onValueChange = { sliderValues[0] = it },
                valueRange = 0f..10f,
                steps = 9,
                onValueChangeFinished = {
                    sliderValues[0] = sliderValues[0].roundToInt().toFloat()
                }
            )
            Text(
                text = sliderValues[0].toInt().toString(),
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
        item {
            Text(
                text = "How often have you felt that you were unable to control the important things in your life?",
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Slider(
                value = sliderValues[1],
                onValueChange = { sliderValues[1] = it },
                valueRange = 0f..10f,
                steps = 9,
                onValueChangeFinished = {
                    sliderValues[1] = sliderValues[1].roundToInt().toFloat()
                }
            )
            Text(
                text = sliderValues[1].toInt().toString(),
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
        item {
            Text(
                text = "How often have you felt nervous and stressed?",
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Slider(
                value = sliderValues[2],
                onValueChange = { sliderValues[2] = it },
                valueRange = 0f..10f,
                steps = 9,
                onValueChangeFinished = {
                    sliderValues[2] = sliderValues[2].roundToInt().toFloat()
                }
            )
            Text(
                text = sliderValues[2].toInt().toString(),
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
        item {
            Text(
                text = "How often have you felt confident about your ability to handle your personal problems?",
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Slider(
                value = sliderValues[3],
                onValueChange = { sliderValues[3] = it },
                valueRange = 0f..10f,
                steps = 9,
                onValueChangeFinished = {
                    sliderValues[3] = sliderValues[3].roundToInt().toFloat()
                }
            )
            Text(
                text = sliderValues[3].toInt().toString(),
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
        item {
            Text(
                text = "How often have you felt that things were going your way?",
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Slider(
                value = sliderValues[4],
                onValueChange = { sliderValues[4] = it },
                valueRange = 0f..10f,
                steps = 9,
                onValueChangeFinished = {
                    sliderValues[4] = sliderValues[4].roundToInt().toFloat()
                }
            )
            Text(
                text = sliderValues[4].toInt().toString(),
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
        item {
            Text(
                text = "How often have you found that you could not cope with all the things that you had to do?",
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Slider(
                value = sliderValues[5],
                onValueChange = { sliderValues[5] = it },
                valueRange = 0f..10f,
                steps = 9,
                onValueChangeFinished = {
                    sliderValues[5] = sliderValues[5].roundToInt().toFloat()
                }
            )
            Text(
                text = sliderValues[5].toInt().toString(),
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
        item {
            Text(
                text = "How often have you been able to control irritations in your life?",
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Slider(
                value = sliderValues[6],
                onValueChange = { sliderValues[6] = it },
                valueRange = 0f..10f,
                steps = 9,
                onValueChangeFinished = {
                    sliderValues[6] = sliderValues[6].roundToInt().toFloat()
                }
            )
            Text(
                text = sliderValues[6].toInt().toString(),
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
        item {
            Text(
                text = "How often have you felt that you were on top of things?",
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Slider(
                value = sliderValues[7],
                onValueChange = { sliderValues[7] = it },
                valueRange = 0f..10f,
                steps = 9,
                onValueChangeFinished = {
                    sliderValues[7] = sliderValues[7].roundToInt().toFloat()
                }
            )
            Text(
                text = sliderValues[7].toInt().toString(),
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
        item {
            Text(
                text = "How often have you been angered because of things that happened that were outside of your control?",
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Slider(
                value = sliderValues[8],
                onValueChange = { sliderValues[8] = it },
                valueRange = 0f..10f,
                steps = 9,
                onValueChangeFinished = {
                    sliderValues[8] = sliderValues[8].roundToInt().toFloat()
                }
            )
            Text(
                text = sliderValues[8].toInt().toString(),
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
        item {
            Text(
                text = "How often have you felt difficulties were piling up so high that you could not overcome them?",
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Slider(
                value = sliderValues[9],
                onValueChange = { sliderValues[9] = it },
                valueRange = 0f..10f,
                steps = 9,
                onValueChangeFinished = {
                    sliderValues[9] = sliderValues[9].roundToInt().toFloat()
                }
            )
            Text(
                text = sliderValues[9].toInt().toString(),
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
        item {
            Button(
                onClick = {
                    saveSliderValue(navController.context, sliderValues.map { it.toInt() })
                    navController.popBackStack()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1976D2)
                )
            ) {
                Text("Submit")
            }

            Button(
                onClick = {
                    navController.navigate("usage_categories")
                }
            ) {
                Text("Show Data")
            }
        }
    }

}
