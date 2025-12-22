package dev.gearturner.deepwatch.saveData

import android.content.Context
import com.google.gson.GsonBuilder
import dev.gearturner.deepwatch.screens.usage.CategoryUsage
import java.io.File

fun saveCategoryUsageData(
    context: Context,
    categories: List<CategoryUsage>
) {
    val gson = GsonBuilder()
        .setPrettyPrinting()
        .create()

    val data = mapOf(
        "generatedAt" to System.currentTimeMillis(),
        "categories" to categories
    )

    val jsonString = gson.toJson(data)

    val file = File(context.filesDir, "category_usage.json")
    file.writeText(jsonString)
}
