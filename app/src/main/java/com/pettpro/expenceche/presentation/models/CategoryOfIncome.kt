package com.pettpro.expenceche.presentation.models

import androidx.compose.ui.graphics.Color
import com.pettpro.expenceche.presentation.colors.colorsOfCategories
import kotlin.collections.get

sealed class CategoryOfIncome(val color: Color)  {
    data object P2P : CategoryOfIncome(colorsOfCategories[0])
    data object Replenishment : CategoryOfIncome((colorsOfCategories[1]))
    data object Other : CategoryOfIncome((colorsOfCategories[2]))
}

