package com.applaunch.jcui.ui.navigation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.applaunch.jcui.ui.theme.DarkBlack
import com.applaunch.jcui.ui.theme.Drax
import com.applaunch.jcui.ui.theme.LightBlack
import com.applaunch.jcui.ui.utils.ConstantBottom.BottomNavItems

@Composable
fun BottomNavigationBar(navController: NavHostController) {

    BottomNavigation(
        // set background color
        backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = LightBlack,
                shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp)
            )
            .clip(RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp))
    ) {

        // observe the backstack
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        // observe current route to change the icon
        // color,label color when navigated
        val currentRoute = navBackStackEntry?.destination?.route
        // Bottom nav items we declared
        BottomNavItems.forEach { navItem ->

            // Place the bottom nav items
            BottomNavigationItem(

                // it currentRoute is equal then its selected route
                selected = currentRoute == navItem.route,

                // navigate on click
                onClick = {
                    navController.navigate(navItem.route){
                        launchSingleTop = true
                    }

                },
                icon = {
                    Icon(painterResource(id = navItem.icon), contentDescription = navItem.label)
                },

                // label
                label = {
                    Text(text = navItem.label, color = Drax, fontSize = 9.sp)
                },
                selectedContentColor = Drax,
                unselectedContentColor = DarkBlack,
                alwaysShowLabel = true
            )
        }
    }
}