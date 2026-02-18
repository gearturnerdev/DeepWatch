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
fun DailySurvey(navController: NavHostController){
    var sliderValues = remember {
        mutableStateListOf(5f, 5f, 5f)
    }
    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 96.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(96.dp)
    ){
        item{
            Text(
                text = "Daily Check-in",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                lineHeight = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }
        item{
            Text(
                text = "How is your mood today?"
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
        item{
            Text(
                text = "How anxious are you today?"
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
        item{
            Text(
                text = "How well did you sleep last night?"
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
        item{
            Button(
                onClick = {
                    saveSliderValue(navController.context, sliderValues.map { it.toInt() })
                    navController.navigate("submitted")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1976D2)
                )
            ) {
                Text("Submit")
            }

        }
    }
}

