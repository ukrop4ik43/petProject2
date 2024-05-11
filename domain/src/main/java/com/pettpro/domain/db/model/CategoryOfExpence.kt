package com.pettpro.domain.db.model


sealed interface CategoryOfExpence {
    data object Grocery : CategoryOfExpence
    data object Electronic : CategoryOfExpence
    data object Healthcare : CategoryOfExpence
    data object Taxi : CategoryOfExpence
    data object Restaurants : CategoryOfExpence
    data object Entertainment : CategoryOfExpence


}