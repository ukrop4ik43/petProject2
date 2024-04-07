package com.pettpro.expenceche.presentration.welcome

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.pettpro.expenceche.presentration.viewmodel.SplashViewModel


@ExperimentalPagerApi
@ExperimentalAnimationApi
@Composable
fun WelcomeScreen(
    navController: NavHostController,
    splashViewModel: SplashViewModel = hiltViewModel()
) {
    Log.d("sdasad", splashViewModel.getOnBoardingState().toString())
}