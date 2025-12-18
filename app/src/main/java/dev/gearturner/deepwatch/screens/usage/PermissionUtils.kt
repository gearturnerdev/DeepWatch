package dev.gearturner.deepwatch.screens.usage

import android.app.AppOpsManager
import android.content.Context

fun hasUsagePermission(context: Context): Boolean {
    val appOps = context.getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager

    val mode = appOps.checkOpNoThrow(
        AppOpsManager.OPSTR_GET_USAGE_STATS,
        android.os.Process.myUid(),
        context.packageName
    )

    return mode == AppOpsManager.MODE_ALLOWED
}