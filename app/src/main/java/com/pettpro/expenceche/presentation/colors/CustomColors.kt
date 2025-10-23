package com.pettpro.expenceche.presentation.colors

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val YellowCustom = Color(0xFFEEBA19)
val YellowCustomSecond = Color(0xFFC99B0F)
val DarkGrey200 = Color(0xFF292929)
val blackGradient = Brush.verticalGradient(
    colors = listOf(
        Color.Black,
        Color.DarkGray
    )
)

// add the colors as per the number of data(no. of pie chart entries)
// so that each data will get a color
val colorsOfCategories = listOf(
    Color(0xFFB389FF),
    Color(0xFF65F143),
    Color(0xFFF7BC6E),
    Color(0xFF76ADFF),
    Color(0xFFFF5722),
    Color(0xFF0E8F7B),
    Color(0xFFFAEE84)
)
val blackGradient200 = Brush.verticalGradient(
    colors = listOf(
        Color.Black,
        DarkGrey200
    )
)

val yellowBackgroundBrush = Brush.verticalGradient(
    colors = listOf(
        YellowCustomSecond,
        YellowCustom
    )
)