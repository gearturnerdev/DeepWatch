package dev.gearturner.deepwatch.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlin.math.roundToInt
import dev.gearturner.deepwatch.saveData.saveSliderValue

@Composable
fun SliderScreen(navController: NavHostController) {
    var sliderValues = remember {
        mutableStateListOf(3f, 3f, 3f, 3f, 3f, 3f, 3f, 3f, 3f, 3f)
    }
    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 96.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(96.dp)
    ) {
        item {
            Text(
                text = "Answer the following questions based on your experience today.",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                lineHeight = 32.sp
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
                valueRange = 1f..5f,
                steps = 3,
                onValueChangeFinished = {
                    sliderValues[0] = sliderValues[0].roundToInt().toFloat()
                }
            )
            SliderDescriptor()
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
                valueRange = 1f..5f,
                steps = 3,
                onValueChangeFinished = {
                    sliderValues[1] = sliderValues[1].roundToInt().toFloat()
                }
            )
            SliderDescriptor()
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
                valueRange = 1f..5f,
                steps = 3,
                onValueChangeFinished = {
                    sliderValues[2] = sliderValues[2].roundToInt().toFloat()
                }
            )
            SliderDescriptor()
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
                valueRange = 1f..5f,
                steps = 3,
                onValueChangeFinished = {
                    sliderValues[3] = sliderValues[3].roundToInt().toFloat()
                }
            )
            SliderDescriptor()
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
                valueRange = 1f..5f,
                steps = 3,
                onValueChangeFinished = {
                    sliderValues[4] = sliderValues[4].roundToInt().toFloat()
                }
            )
            SliderDescriptor()
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
                valueRange = 1f..5f,
                steps = 3,
                onValueChangeFinished = {
                    sliderValues[5] = sliderValues[5].roundToInt().toFloat()
                }
            )
            SliderDescriptor()
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
                valueRange = 1f..5f,
                steps = 3,
                onValueChangeFinished = {
                    sliderValues[6] = sliderValues[6].roundToInt().toFloat()
                }
            )
            SliderDescriptor()
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
                valueRange = 1f..5f,
                steps = 3,
                onValueChangeFinished = {
                    sliderValues[7] = sliderValues[7].roundToInt().toFloat()
                }
            )
            SliderDescriptor()
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
                valueRange = 1f..5f,
                steps = 3,
                onValueChangeFinished = {
                    sliderValues[8] = sliderValues[8].roundToInt().toFloat()
                }
            )
            SliderDescriptor()
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
                valueRange = 1f..5f,
                steps = 3,
                onValueChangeFinished = {
                    sliderValues[9] = sliderValues[9].roundToInt().toFloat()
                }
            )
            SliderDescriptor()
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
                    navController.navigate("usage")
                }
            ) {
                Text("Show Data")
            }
        }
    }

}

@Composable
fun SliderDescriptor() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        for (num in 0..4) {
            Text(
                text = num.toString(),
            )
        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Start,
            fontSize = 14.sp,
            text = "Never"
        )
        Text(
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            text = "Sometimes"
        )
        Text(
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.End,
            fontSize = 14.sp,
            text = "Very often"
        )
    }
}