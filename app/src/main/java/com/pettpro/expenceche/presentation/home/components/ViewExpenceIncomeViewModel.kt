package com.pettpro.expenceche.presentation.home.components

import androidx.lifecycle.ViewModel
import com.pettpro.domain.add_expence_income.model.CategoryOfExpence
import com.pettpro.domain.add_expence_income.model.CategoryOfIncome
import com.pettpro.domain.db.model.Expence
import com.pettpro.domain.db.model.Income
import com.pettpro.domain.home.CategoriesMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ViewExpenceIncomeViewModel @Inject constructor(
    private val categoriesMapper: CategoriesMapper
) : ViewModel() {
    fun getCategoryOfExpence(expence: Expence): CategoryOfExpence {
        return categoriesMapper.setExpenceCategory(expence.category)
    }

    fun getCategoryOfIncome(income: Income): CategoryOfIncome {
        return categoriesMapper.setIncomeCategory(income.category)
    }
}