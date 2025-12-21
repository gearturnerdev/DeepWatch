package dev.gearturner.deepwatch.screens.usage

import android.app.usage.UsageStats
import android.app.usage.UsageStatsManager
import android.content.Context
import android.content.pm.PackageManager
import java.util.Calendar

data class AppUsage(
    val appName: String,
    val packageName: String,
    val usageMinutes: Long
)

fun isSystemNoise(packageName: String): Boolean {
    return packageName.startsWith("com.android") ||
            packageName.startsWith("android") ||
            packageName.contains("launcher") ||
            packageName.contains("inputmethod") ||
            packageName.contains("systemui") ||
            packageName.contains("googlequicksearchbox")
}

fun hasLauncherIntent(pm: PackageManager, packageName: String): Boolean {
    return pm.getLaunchIntentForPackage(packageName) != null
}

fun getUsageStats(context: Context): List<AppUsage> {
    val usageStatsManager =
        context.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager

    val calendar = Calendar.getInstance()

    // Start of today (12:00 AM)
    calendar.set(Calendar.HOUR_OF_DAY, 0)
    calendar.set(Calendar.MINUTE, 0)
    calendar.set(Calendar.SECOND, 0)
    calendar.set(Calendar.MILLISECOND, 0)
    val start = calendar.timeInMillis

    // End of today (11:59:59 PM)
    calendar.set(Calendar.HOUR_OF_DAY, 23)
    calendar.set(Calendar.MINUTE, 59)
    calendar.set(Calendar.SECOND, 59)
    calendar.set(Calendar.MILLISECOND, 999)
    val end = calendar.timeInMillis


    val stats = usageStatsManager.queryUsageStats(
        UsageStatsManager.INTERVAL_DAILY,
        start,
        end
    )

    val pm = context.packageManager
    val usageMap = mutableMapOf<String, AppUsage>()

    for (usage in stats) {

        if (usage.totalTimeInForeground == 0L) continue

        val minutes = usage.totalTimeInForeground / 1000 / 60
        if (minutes == 0L) continue

        val appName = try {
            val appInfo = pm.getApplicationInfo(usage.packageName, 0)
            pm.getApplicationLabel(appInfo).toString()
        } catch (e: Exception) {
            usage.packageName.substringAfterLast(".")
        }

        val existing = usageMap[usage.packageName]

        if (existing == null) {
            usageMap[usage.packageName] = AppUsage(
                appName = appName,
                packageName = usage.packageName,
                usageMinutes = minutes
            )
        } else {
            usageMap[usage.packageName] = existing.copy(
                usageMinutes = existing.usageMinutes + minutes
            )
        }
    }

    return usageMap.values.sortedByDescending { it.usageMinutes }

}