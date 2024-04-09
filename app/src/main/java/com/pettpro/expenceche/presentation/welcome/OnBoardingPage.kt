package com.pettpro.expenceche.presentation.welcome

import androidx.annotation.DrawableRes
import com.pettpro.expenceche.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val description: String
) {
    data object First : OnBoardingPage(
        image = R.drawable.first,
        description = "Welcome to Expence Checker!"
    )

    data object Second : OnBoardingPage(
        image = R.drawable.second,
        description = "With this app you will discover new levels of financial literacy."
    )

    data object Third : OnBoardingPage(
        image = R.drawable.third,
        description = "You can track all your expences comfy here."
    )

    data object Fourth : OnBoardingPage(
        image = R.drawable.fourth,
        description = "Hope this app will help you in your financial adventure!Good luck!"
    )
}
