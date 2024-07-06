package com.pettpro.expenceche.presentation.add_expence_income.model

import com.pettpro.domain.db.model.CategoryOfExpence
import com.pettpro.domain.db.model.CategoryOfIncome

sealed class AddExpenceIncomeFormEvent {
    data class AmountChange(val amount: String) : AddExpenceIncomeFormEvent()
    data class CategoryExpenceChange(val category: String) : AddExpenceIncomeFormEvent()

    data class CategoryIncomeChange(val category: String) : AddExpenceIncomeFormEvent()
    data class ShowToast(val text: String) : AddExpenceIncomeFormEvent()
    data object Sumbit : AddExpenceIncomeFormEvent()
}