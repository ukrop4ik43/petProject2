package com.pettpro.expenceche.presentation.home.custom_view

import androidx.lifecycle.ViewModel
import com.pettpro.expenceche.presentation.models.CategoryOfExpence
import com.pettpro.expenceche.presentation.models.CategoryOfIncome
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
        return categoriesMapper.setExpenceCaterogy(expence.category)
    }

    fun getCategoryOfIncome(income: Income): CategoryOfIncome {
        return categoriesMapper.setIncomeCaterogy(income.category)
    }
}