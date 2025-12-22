package dev.gearturner.deepwatch.screens.usage

import dev.gearturner.deepwatch.Classifiers.AppCategory


data class CategoryUsage(
    val category: AppCategory,
    val totalMinutes: Long
)

fun groupUsageByCategory(apps: List<AppUsage>): List<CategoryUsage> {
    return apps
        .groupBy { it.category }
        .map { (category, appsInCategory) ->
            CategoryUsage(
                category = category,
                totalMinutes = appsInCategory.sumOf { it.usageMinutes }
            )
        }
        .sortedByDescending { it.totalMinutes }
}
