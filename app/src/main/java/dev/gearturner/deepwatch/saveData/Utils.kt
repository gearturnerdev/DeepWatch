package dev.gearturner.deepwatch.saveData

import android.content.Context
import com.google.gson.Gson
import java.io.File

fun saveSliderValue(context: Context, values: List<Int>) {
    val gson = Gson()

    val toReverse = intArrayOf(3, 4, 6, 7)
    val correctedValues = values.mapIndexed { index, value ->
        if(index in toReverse) 4 - value else value
    }

    val totalScore = correctedValues.sum()
    val stressLevel = if(totalScore < 14) {
        "low"
    } else if(totalScore < 27) {
        "moderate"
    } else {
        "high"
    }
    val data = correctedValues.mapIndexed { index, value ->
        "q${index + 1}" to value
    }.toMap() + ("score" to totalScore) + ("stressLevel" to stressLevel)

    val jsonString = gson.toJson(data)
    val file = File(context.filesDir, "stress_data.json")

    file.writeText(jsonString)
}