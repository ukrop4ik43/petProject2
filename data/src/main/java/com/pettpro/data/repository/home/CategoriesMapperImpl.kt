package com.pettpro.data.repository.home

import com.pettpro.domain.add_expence_income.model.CategoryOfExpence
import com.pettpro.domain.add_expence_income.model.CategoryOfIncome
import com.pettpro.domain.home.CategoriesMapper

class CategoriesMapperImpl:CategoriesMapper {
    override  fun setIncomeCategory(category: String): CategoryOfIncome {
        when (category) {
            "P2P"
            -> return CategoryOfIncome.P2P

            "Replenishment"
            -> return CategoryOfIncome.Replenishment

            "Other"
            -> return CategoryOfIncome.Other
        }
        return CategoryOfIncome.Other
    }

    override  fun setExpenceCategory(category: String): CategoryOfExpence {
        when (category) {
            "Grocery"
            -> return CategoryOfExpence.Grocery

            "Entertainment"
            -> return CategoryOfExpence.Entertainment

            "Restaurants"
            -> return CategoryOfExpence.Restaurants

            "Electronic"
            -> return CategoryOfExpence.Electronic

            "Transport"
            -> return CategoryOfExpence.Transport

            "Healthcare"
            -> return CategoryOfExpence.Healthcare

            "Other"
            -> return CategoryOfExpence.Other
        }
        return CategoryOfExpence.Other
    }
}