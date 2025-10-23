package com.pettpro.expenceche.presentation.models

import androidx.compose.ui.graphics.Color
import com.pettpro.expenceche.presentation.colors.colorsOfCategories


sealed class CategoryOfExpence(val color: Color) {
    data object Grocery : CategoryOfExpence(colorsOfCategories[0])
    data object Electronic : CategoryOfExpence(colorsOfCategories[1])
    data object Healthcare : CategoryOfExpence(colorsOfCategories[2])
    data object Transport : CategoryOfExpence(colorsOfCategories[3])
    data object Restaurants : CategoryOfExpence(colorsOfCategories[4])
    data object Entertainment : CategoryOfExpence(colorsOfCategories[5])

    data object Other : CategoryOfExpence(colorsOfCategories[6])
}

val categoryOfExpence = mutableListOf(
    CategoryOfExpence.Grocery,
    CategoryOfExpence.Electronic,
    CategoryOfExpence.Healthcare,
    CategoryOfExpence.Transport,
    CategoryOfExpence.Restaurants,
    CategoryOfExpence.Entertainment,
    CategoryOfExpence.Other
)
val categoryOfIncome =
    mutableListOf(
        CategoryOfIncome.P2P,
        CategoryOfIncome.Replenishment,
        CategoryOfIncome.Other
    )