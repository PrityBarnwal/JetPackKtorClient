package com.applaunch.jcui.ui.utils

import com.applaunch.jcui.R
import com.applaunch.jcui.ui.model.BottomModel.BottomNavItem
import com.applaunch.jcui.ui.navigation.BGMScreen

object ConstantBottom {
    val BottomNavItems = listOf(
        BottomNavItem(
            label = "Home",
            icon =  R.drawable.ic_home,
            route = BGMScreen.HomeScreen.name
        ),
        BottomNavItem(
            label = "Meet",
            icon = R.drawable.ic_meet,
            route = BGMScreen.MeetScreen.name
        ),
        BottomNavItem(
            label = "Challenge",
            icon =R.drawable.ic_challenge,
            route = BGMScreen.ChallengeScreen.name
        ),
        BottomNavItem(
            label = "Favorites",
            icon =R.drawable.ic_favorite,
            route = BGMScreen.FavoritesScreen.name
        ),
        BottomNavItem(
            label = "Setting",
            icon =R.drawable.ic_setting,
            route = BGMScreen.SettingScreen.name
        )
    )
}