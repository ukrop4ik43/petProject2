package com.pettpro.expenceche

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.pettpro.expenceche.presentration.navigation.ScreensNav
import com.pettpro.expenceche.ui.theme.ExpenceCheckerTheme
import dagger.hilt.android.AndroidEntryPoint


@ExperimentalPagerApi
@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpenceCheckerTheme {
                    ScreensNav(navController = rememberNavController())
            }
        }
    }
}
