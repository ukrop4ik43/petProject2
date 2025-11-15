package com.pettpro.expenceche.presentation.add_expence_income.model

import com.pettpro.domain.home.TypeOfContentInDashBoardTab

sealed class AddExpenceIncomeEvent {
    data class AmountChange(val amount: String) : AddExpenceIncomeEvent()
    data class CategoryExpenceChange(val category: String) : AddExpenceIncomeEvent()
    data class SetTypeOfMoneyFlow(val type: TypeOfContentInDashBoardTab):AddExpenceIncomeEvent()
    data class CategoryIncomeChange(val category: String) : AddExpenceIncomeEvent()
    data class ShowToast(val text: String) : AddExpenceIncomeEvent()
    data object Submit : AddExpenceIncomeEvent()
}