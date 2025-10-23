package com.pettpro.domain.home

import com.pettpro.domain.add_expence_income.model.CategoryOfExpence
import com.pettpro.domain.add_expence_income.model.CategoryOfIncome


interface CategoriesMapper {

    fun setIncomeCategory(category: String): CategoryOfIncome
    fun setExpenceCategory(category: String): CategoryOfExpence
}