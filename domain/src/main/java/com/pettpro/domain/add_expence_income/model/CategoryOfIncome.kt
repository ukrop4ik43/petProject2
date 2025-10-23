package com.pettpro.domain.add_expence_income.model

import kotlin.collections.get

sealed interface CategoryOfIncome  {
    data object P2P : CategoryOfIncome
    data object Replenishment : CategoryOfIncome
    data object Other : CategoryOfIncome
}

