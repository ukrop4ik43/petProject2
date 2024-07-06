package com.pettpro.domain.add_expence_income.model


data class AddExpenceIncomeValidationResults (
    val successful:Boolean,
    val errorMessage:String? =null
)
