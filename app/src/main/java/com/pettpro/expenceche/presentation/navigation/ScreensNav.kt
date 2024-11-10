package com.pettpro.expenceche.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.pettpro.domain.home.TypeOfContentInDashBoardTab
import com.pettpro.expenceche.presentation.add_expence_income.AddExpenceIncomeScreen
import com.pettpro.expenceche.presentation.home.HomeScreen
import com.pettpro.expenceche.presentation.login.LoginScreen
import com.pettpro.expenceche.presentation.no_internet.NoInternetScreen
import com.pettpro.expenceche.presentation.registration.RegisterScreen
import com.pettpro.expenceche.presentation.welcome.WelcomeScreen


@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalPagerApi
@ExperimentalAnimationApi
@Composable
fun ScreensNav(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Welcome.route) {
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
        composable(NavigationItem.NoInternet.route) {
            NoInternetScreen(navController = navController)
        }
        composable(NavigationItem.AddExpenceIncome.route) { backStackEntry ->
            val typeString = backStackEntry.arguments?.getString("typeOfContent")
            val type = when (typeString) {
                "expences" -> TypeOfContentInDashBoardTab.Expences
                "incomes" -> TypeOfContentInDashBoardTab.Incomes

                else -> {TypeOfContentInDashBoardTab.Incomes}
            }
            AddExpenceIncomeScreen(
                navController = navController,
                typeOfContentInDashBoardTab = type
            )
        }
    }
}


