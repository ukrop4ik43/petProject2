package com.pettpro.expenceche.presentation.home.custom_view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.pettpro.domain.db.model.Expence
import com.pettpro.domain.home.CategoriesMapper
import com.pettpro.expenceche.presentation.home.HomeViewModel
import java.time.LocalDate
import javax.inject.Inject


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ViewOfExpence(expence: Expence, viewModel: ViewExpenceIncomeViewModel = hiltViewModel()) {

    val dateOfAdding = LocalDate.parse(expence.date)
    val amount = expence.amount
    val category = viewModel.getCategoryOfExpence(expence)

}

