package com.applaunch.jcui.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.applaunch.jcui.ui.screen.*
import com.applaunch.jcui.ui.screen.Home.HomeScreen
import com.applaunch.jcui.viewModel.HomeViewModel

@Composable
fun NavHostContainer(
    navController: NavHostController
) {

    NavHost(
        navController = navController,

        startDestination = BGMScreen.HomeScreen.name,

        builder = {

            // route : Home
            composable(BGMScreen.HomeScreen.name) {
                val homeViewModel = hiltViewModel<HomeViewModel>()
                HomeScreen(navController,homeViewModel)
            }

            // route : meet
            composable(BGMScreen.MeetScreen.name) {
                val meetViewModel = hiltViewModel<HomeViewModel>()
               MeetScreen(navController,meetViewModel)
            }

            // route : challenge
            composable(BGMScreen.ChallengeScreen.name) {
                ChallengeScreen()
            }
            // route : favorite
            composable(BGMScreen.FavoritesScreen.name) {
                FavoritesScreen()
            }

            // route : setting
            composable(BGMScreen.SettingScreen.name) {
                SettingScreen()
            }
        })

}