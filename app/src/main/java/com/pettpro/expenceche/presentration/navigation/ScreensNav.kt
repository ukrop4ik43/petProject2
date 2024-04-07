package com.pettpro.expenceche.presentration.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.pettpro.expenceche.presentration.welcome.WelcomeScreen


@ExperimentalPagerApi
@ExperimentalAnimationApi
@Composable
fun ScreensNav(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Welcome.route) {
        composable(NavigationItem.Welcome.route) {
            WelcomeScreen(navController)
        }
//        composable(NavigationItem.Login.route) {
//            AddProjectScreen()
//        }
//        composable("addTask") {
//            AddTaskScreen()
//        }
    }
}