package com.pettpro.expenceche.presentation.home.custom_view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pettpro.domain.db.model.CategoryOfExpence
import com.pettpro.domain.db.model.CategoryOfIncome
import com.pettpro.domain.db.model.Income
import com.pettpro.expenceche.presentation.colors.DarkGrey200
import com.pettpro.expenceche.presentation.colors.colorsOfCategories
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ViewOfIncome(income: Income, viewModel: ViewExpenceIncomeViewModel = hiltViewModel()) {
    val dateOfAdding = income.date
    val amount = income.amount
    val category = viewModel.getCategoryOfIncome(income)
    val colorOfTheCategory = colorOfCategoryIncome(category)
    Spacer(
        modifier = Modifier
            .height(5.dp)
            .fillMaxWidth()
    )
    Box(
        modifier = Modifier
            .padding(start = 10.dp, end = 70.dp)
            .fillMaxWidth()
            .background(
                color = DarkGrey200,
                shape = RoundedCornerShape(10.dp)
            )
            .height(100.dp), contentAlignment = Alignment.CenterStart
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .background(
                        color = colorOfTheCategory,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .size(30.dp)

            )
            Column {
                Text(
                    modifier = Modifier.padding(start = 18.dp),
                    text = category.toString(),
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    color = Color.LightGray
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    modifier = Modifier.padding(start = 18.dp),
                    text = dateOfAdding,
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    color = Color.LightGray
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    modifier = Modifier.padding(start = 18.dp),
                    text = "Amount:$amount$",
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    color = Color.LightGray
                )
            }
        }

    }
}

@Composable
private fun colorOfCategoryIncome(category: CategoryOfIncome) = when (category) {
    CategoryOfIncome.P2P -> {
        colorsOfCategories[0]
    }
    CategoryOfIncome.Replenishment -> {
        colorsOfCategories[1]
    }
    CategoryOfIncome.Other -> {
        colorsOfCategories[2]
    }

    else -> {
        colorsOfCategories[2]
    }
}