package dev.gearturner.deepwatch.Classifiers

fun classifyApp(appName: String, packageName: String): AppCategory {
    val name = appName.lowercase()
    val pkg = packageName.lowercase()

    return when {
        // SOCIAL MEDIA
        listOf("instagram", "facebook", "snapchat", "tiktok", "twitter", "reddit")
            .any { it in name } ->
            AppCategory.SOCIAL_MEDIA

        // ENTERTAINMENT
        listOf("youtube", "netflix", "spotify", "prime", "hulu", "photos")
            .any { it in name } ->
            AppCategory.ENTERTAINMENT

        // GAMING
        listOf("game", "minecraft", "roblox", "pubg", "clash")
            .any { it in name || it in pkg } ->
            AppCategory.GAMING

        // COMMUNICATION
        listOf("whatsapp", "messenger", "telegram", "discord", "signal")
            .any { it in name } ->
            AppCategory.COMMUNICATION

        // PRODUCTIVITY
        listOf("gmail", "calendar", "docs", "drive", "notion", "office", "deepwatch")
            .any { it in name } ->
            AppCategory.PRODUCTIVITY

        // SYSTEM
        pkg.startsWith("com.android") || pkg.startsWith("android") ->
            AppCategory.SYSTEM

        else -> AppCategory.OTHER
    }
}