package com.pettpro.expenceche.presentation.add_expence_income.model

import com.pettpro.domain.db.model.CategoryOfExpence
import com.pettpro.domain.db.model.CategoryOfIncome

data class AddExpenceDataState(
    val categoryOfIncome:CategoryOfIncome?=null,
    val categoryOfIncomeError:String? =null,
    val categoryOfExpence:CategoryOfExpence?=null,
    val categoryOfExpenceError:String? =null,
    val amount:String="",
    val amountError:String? =null
)