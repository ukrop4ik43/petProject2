package com.pettpro.expenceche.presentation.colors

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val YellowCustom = Color(0xFFDDD430)

val Yellow200 = Color(0xFFE0DA61)
val blackGradient= Brush.verticalGradient(
    colors = listOf(
        Color.Black,
        Color.DarkGray
    )
)

val yellowGradient= Brush.verticalGradient(
    colors = listOf(
        YellowCustom,
        Yellow200
    )
)