package com.pettpro.expenceche.presentation.util

import androidx.compose.ui.graphics.Color
import com.pettpro.domain.add_expence_income.model.CategoryOfExpence
import com.pettpro.domain.add_expence_income.model.CategoryOfIncome
import com.pettpro.expenceche.presentation.colors.colorsOfCategories

fun CategoryOfExpence.toColor(): Color {
   return when (this) {
        CategoryOfExpence.Electronic -> colorsOfCategories[1]
        CategoryOfExpence.Entertainment -> colorsOfCategories[5]
        CategoryOfExpence.Grocery -> colorsOfCategories[0]
        CategoryOfExpence.Healthcare -> colorsOfCategories[2]
        CategoryOfExpence.Other -> colorsOfCategories[6]
        CategoryOfExpence.Restaurants -> colorsOfCategories[4]
        CategoryOfExpence.Transport -> colorsOfCategories[3]
    }
}


fun CategoryOfIncome.toColor():Color{
    return when (this) {
        CategoryOfIncome.Other -> colorsOfCategories[2]
        CategoryOfIncome.P2P -> colorsOfCategories[0]
        CategoryOfIncome.Replenishment -> colorsOfCategories[1]
    }
}
