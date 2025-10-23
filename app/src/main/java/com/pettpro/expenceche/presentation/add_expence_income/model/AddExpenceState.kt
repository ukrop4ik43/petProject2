package com.pettpro.expenceche.presentation.add_expence_income.model

import com.pettpro.domain.db.model.User
import com.pettpro.expenceche.presentation.models.CategoryOfExpence
import com.pettpro.expenceche.presentation.models.CategoryOfIncome

data class AddExpenceState(
    val categoryOfIncome:CategoryOfIncome?=CategoryOfIncome.P2P,
    val categoryOfIncomeError:String? =null,
    val categoryOfExpence:CategoryOfExpence?=CategoryOfExpence.Grocery,
    val categoryOfExpenceError:String? =null,
    val amount:String="",
    val amountError:String? =null,
    val user:User=User()
)