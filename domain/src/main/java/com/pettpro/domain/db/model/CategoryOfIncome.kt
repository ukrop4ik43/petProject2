package com.pettpro.domain.db.model

sealed interface CategoryOfIncome {
    data object P2P : CategoryOfIncome
    data object Replenishment : CategoryOfIncome

    data object Other : CategoryOfIncome
}