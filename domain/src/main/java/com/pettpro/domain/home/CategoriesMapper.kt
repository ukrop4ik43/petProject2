package com.pettpro.domain.home

import com.pettpro.domain.db.model.CategoryOfExpence
import com.pettpro.domain.db.model.CategoryOfIncome

interface CategoriesMapper {

    fun setIncomeCaterogy(category: String): CategoryOfIncome
    fun setExpenceCaterogy(category: String): CategoryOfExpence
}