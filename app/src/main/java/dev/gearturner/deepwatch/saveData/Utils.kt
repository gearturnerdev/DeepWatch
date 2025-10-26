package dev.gearturner.deepwatch.saveData

import android.content.Context
import com.google.gson.Gson
import java.io.File

fun saveSliderValue(context: Context, value: Int) {
    val gson = Gson()
    val data = mapOf("stress_level" to value);

    val jsonString = gson.toJson(data)
    val file = File(context.filesDir, "stress_data.json")

    file.writeText(jsonString)

}