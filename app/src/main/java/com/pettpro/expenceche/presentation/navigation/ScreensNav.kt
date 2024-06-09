package com.pettpro.expenceche.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.pettpro.expenceche.presentation.home.HomeScreen
import com.pettpro.expenceche.presentation.login.LoginScreen
import com.pettpro.expenceche.presentation.registration.RegisterScreen
import com.pettpro.expenceche.presentation.welcome.WelcomeScreen


@ExperimentalPagerApi
@ExperimentalAnimationApi
@Composable
fun ScreensNav(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Welcome.route) {
            WelcomeScreen(navController)
        }
        composable(NavigationItem.Login.route) {
            LoginScreen(navController)
        }
        composable(NavigationItem.Register.route) {
            RegisterScreen(navController)
        }
        composable(NavigationItem.Home.route) {
            HomeScreen(navController = navController)
        }
    }
}


