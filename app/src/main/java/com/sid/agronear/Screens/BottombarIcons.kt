package com.sid.agronear.Screens

import com.sid.agronear.R
import com.sid.agronear.Routes
import com.sid.agronear.model.BottomBarItem

val bottomBarItems = listOf(
    BottomBarItem(
        route = Routes.MainAppScreen,
        icon = R.drawable.homeicon,
        label = "Home"
    ),
    BottomBarItem(
        route = Routes.MyProductsScreen,
        icon = R.drawable.inventory,
        label = "My Products"
    ),
    BottomBarItem(
        route = Routes.ProfileScreen,
        icon = R.drawable.profileicon,
        label = "Profile"
    )
)
