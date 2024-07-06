package com.pettpro.domain.add_expence_income

import com.pettpro.domain.add_expence_income.model.AddExpenceIncomeValidationResults
import com.pettpro.domain.db.model.User

interface AddExpenceIncomeVerifyingRepository {
    fun checkAmount(amount:String): AddExpenceIncomeValidationResults
}