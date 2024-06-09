package com.pettpro.expenceche.presentation.colors

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val YellowCustom = Color(0xFFEEBA19)
val YellowCustomSecond = Color(0xFFC99B0F)
val DarkGrey200 = Color(0xFF292929)
val blackGradient= Brush.verticalGradient(
    colors = listOf(
        Color.Black,
        Color.DarkGray
    )
)

val blackGradient200= Brush.verticalGradient(
    colors = listOf(
        Color.Black,
        DarkGrey200
    )
)

val yellowBackgroundBrush= Brush.verticalGradient(
    colors = listOf(
        YellowCustomSecond,
        YellowCustom
    )
)