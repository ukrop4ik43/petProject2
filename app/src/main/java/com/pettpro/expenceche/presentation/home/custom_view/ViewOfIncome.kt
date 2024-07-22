package com.pettpro.expenceche.presentation.home.custom_view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.pettpro.domain.db.model.Income
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ViewOfIncome(income: Income, viewModel: ViewExpenceIncomeViewModel = hiltViewModel()) {
    val dateOfAdding = LocalDate.parse(income.date)
    val amount = income.amount
    val category = viewModel.getCategoryOfIncome(income)

}