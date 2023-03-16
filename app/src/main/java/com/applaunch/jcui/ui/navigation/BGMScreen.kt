package com.applaunch.jcui.ui.navigation

enum class BGMScreen {
    HomeScreen,
    MeetScreen,
    ChallengeScreen,
    FavoritesScreen,
    SettingScreen;

    companion object {
        fun fromRoute(route: String?): BGMScreen = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            MeetScreen.name -> MeetScreen
            ChallengeScreen.name -> ChallengeScreen
            FavoritesScreen.name -> FavoritesScreen
            SettingScreen.name -> SettingScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}