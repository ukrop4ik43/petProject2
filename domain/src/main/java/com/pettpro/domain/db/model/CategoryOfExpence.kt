package com.pettpro.domain.db.model


sealed interface CategoryOfExpence {
    data object Grocery : CategoryOfExpence
    data object Electronic : CategoryOfExpence
    data object Healthcare : CategoryOfExpence
    data object Transport : CategoryOfExpence
    data object Restaurants : CategoryOfExpence
    data object Entertainment : CategoryOfExpence

    data object Other : CategoryOfExpence
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