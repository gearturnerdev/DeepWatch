package dev.gearturner.deepwatch.saveData

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dev.gearturner.deepwatch.screens.usage.AppUsage
import java.io.File

fun saveUsageData(context: Context, usageList: List<AppUsage>) {
    val gson: Gson = GsonBuilder().setPrettyPrinting().create()

    val data = mapOf(
        "generatedAt" to System.currentTimeMillis(),
        "apps" to usageList
    )

    val jsonString = gson.toJson(data)

    val file = File(context.filesDir, "usage_data.json")
    file.writeText(jsonString)
}
