package com.pettpro.domain.add_expence_income.model



sealed class CategoryOfExpence() {
    data object Grocery : CategoryOfExpence()
    data object Electronic : CategoryOfExpence()
    data object Healthcare : CategoryOfExpence()
    data object Transport : CategoryOfExpence()
    data object Restaurants : CategoryOfExpence()
    data object Entertainment : CategoryOfExpence()

    data object Other : CategoryOfExpence()
}

val categoryOfExpence = listOf(
    CategoryOfExpence.Grocery,
    CategoryOfExpence.Electronic,
    CategoryOfExpence.Healthcare,
    CategoryOfExpence.Transport,
    CategoryOfExpence.Restaurants,
    CategoryOfExpence.Entertainment,
    CategoryOfExpence.Other
)
val categoryOfIncome =
    listOf(
        CategoryOfIncome.P2P,
        CategoryOfIncome.Replenishment,
        CategoryOfIncome.Other
    )