package com.applaunch.jcui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.applaunch.jcui.ui.navigation.BottomNavigationBar
import com.applaunch.jcui.ui.navigation.NavHostContainer
import com.applaunch.jcui.ui.screen.Home.BottomSheet
import com.applaunch.jcui.ui.theme.JCUiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JCUiTheme {
                val navController = rememberNavController()
                Surface(color = Color.White) {
//                    BottomSheet()
                    Scaffold(
                        // Bottom navigation
                        bottomBar = {
                            BottomNavigationBar(navController = navController)
                        }, content = { padding ->
                            Box(modifier = Modifier.padding(padding)) {
                                // Navhost: where screens are placed
                                NavHostContainer(navController = navController)
                            }
                        })
                }
            }
        }
    }
}

