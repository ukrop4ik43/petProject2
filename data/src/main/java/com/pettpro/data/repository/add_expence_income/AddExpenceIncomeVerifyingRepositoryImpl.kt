package com.pettpro.data.repository.add_expence_income

import com.pettpro.domain.add_expence_income.AddExpenceIncomeVerifyingRepository
import com.pettpro.domain.add_expence_income.model.AddExpenceIncomeValidationResults
import com.pettpro.domain.login.model.LoginValidationResults
import javax.inject.Inject

class AddExpenceIncomeVerifyingRepositoryImpl @Inject constructor() :
    AddExpenceIncomeVerifyingRepository {
    override fun checkAmount(amount: String): AddExpenceIncomeValidationResults {
        if (amount.isEmpty()) {
            return AddExpenceIncomeValidationResults(false, "Amount is empty")
        }
        if (amount[0] == '0') {
            return AddExpenceIncomeValidationResults(false, "Wrong format of amount")
        }
        if (amount.contains("-")) {
            return AddExpenceIncomeValidationResults(false, "Amount should not contain (-)")
        }
        return AddExpenceIncomeValidationResults(true)

    }

}