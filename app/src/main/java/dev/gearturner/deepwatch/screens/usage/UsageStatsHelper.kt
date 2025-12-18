package dev.gearturner.deepwatch.screens.usage

import android.app.usage.UsageStats
import android.app.usage.UsageStatsManager
import android.content.Context
import android.content.pm.PackageManager

data class AppUsage(
    val appName: String,
    val packageName: String,
    val usageMinutes: Long
)

fun getUsageStats(context: Context): List<AppUsage> {
    val usageStatsManager =
        context.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager

    val end = System.currentTimeMillis()
    val start = end - (24 * 60 * 60 * 1000) // last 24 hours

    val stats = usageStatsManager.queryUsageStats(
        UsageStatsManager.INTERVAL_DAILY,
        start,
        end
    )

    val pm = context.packageManager
    val usageList = mutableListOf<AppUsage>()

    for (usage in stats) {
        if (usage.totalTimeInForeground > 0) {
            val appName = try {
                pm.getApplicationLabel(
                    pm.getApplicationInfo(usage.packageName, PackageManager.GET_META_DATA)
                ).toString()
            } catch (e: Exception) {
                usage.packageName
            }

            usageList.add(
                AppUsage(
                    appName = appName,
                    packageName = usage.packageName,
                    usageMinutes = usage.totalTimeInForeground / 1000 / 60
                )
            )
        }
    }

    return usageList.sortedByDescending { it.usageMinutes }
}