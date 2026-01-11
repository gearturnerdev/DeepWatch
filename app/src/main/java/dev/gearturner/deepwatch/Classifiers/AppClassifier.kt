package dev.gearturner.deepwatch.Classifiers

fun classifyApp(appName: String, packageName: String): AppCategory {
    val name = appName.lowercase()
    val pkg = packageName.lowercase()

    return when {

        // SYSTEM
        pkg.startsWith("com.android") || pkg.startsWith("android") ->
            AppCategory.SYSTEM

        // SOCIAL
        listOf("instagram", "facebook", "snapchat", "tiktok", "twitter", "reddit")
            .any { it in name || it in pkg } ->
            AppCategory.SOCIAL

        // PRODUCTIVITY & FINANCE
        listOf("gmail", "calendar", "docs", "drive", "office", "notion", "bank", "finance", "deepwatch")
            .any { it in name || it in pkg } ->
            AppCategory.PRODUCTIVITY_AND_FINANCE

        // INFORMATION & READING
        listOf("news", "medium", "wikipedia", "chrome", "browser", "reader")
            .any { it in name || it in pkg } ->
            AppCategory.INFORMATION_AND_READING

        // ENTERTAINMENT
        listOf("youtube", "netflix", "spotify", "prime", "hulu","photos")
            .any { it in name || it in pkg } ->
            AppCategory.ENTERTAINMENT

        // GAMES
        listOf("game", "minecraft", "roblox", "pubg", "clash")
            .any { it in name || it in pkg } ->
            AppCategory.GAMES

        // UTILITIES
        listOf("settings", "calculator", "clock", "files", "manager")
            .any { it in name || it in pkg } ->
            AppCategory.UTILITIES

        // CREATIVITY
        listOf("camera", "photoshop", "lightroom", "canva", "editor")
            .any { it in name || it in pkg } ->
            AppCategory.CREATIVITY

        // SHOPPING & FOOD
        listOf("amazon", "ebay", "ubereats", "doordash", "food", "shop")
            .any { it in name || it in pkg } ->
            AppCategory.SHOPPING_AND_FOOD

        // EDUCATION
        listOf("classroom", "coursera", "udemy", "khan", "education")
            .any { it in name || it in pkg } ->
            AppCategory.EDUCATION

        // TRAVEL
        listOf("maps", "uber", "lyft", "airbnb", "booking")
            .any { it in name || it in pkg } ->
            AppCategory.TRAVEL

        else ->
            AppCategory.OTHER
    }
}
