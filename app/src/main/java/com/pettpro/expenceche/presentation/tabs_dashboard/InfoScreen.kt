package com.pettpro.expenceche.presentation.tabs_dashboard

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pettpro.domain.db.model.Expence
import com.pettpro.domain.db.model.Income
import com.pettpro.domain.home.TypeOfContentInDashBoardTab
import com.pettpro.expenceche.presentation.home.components.ViewOfExpence
import com.pettpro.expenceche.presentation.home.components.ViewOfIncome
import com.pettpro.expenceche.presentation.tabs_dashboard.components.ExpenceOrIncomeButton
import com.pettpro.expenceche.presentation.tabs_dashboard.components.PieChart


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun InfoScreen(
    typeOfContent: TypeOfContentInDashBoardTab,
    arrayListOfIncome: ArrayList<Income>,
    arrayListOfExpence: ArrayList<Expence>,
    dataForTheChart: Map<String, Int>,
    onButtonClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            PieChart(
                dataForTheChart
            )
            if (typeOfContent == TypeOfContentInDashBoardTab.Incomes) {
                for (item in arrayListOfIncome) {
                    ViewOfIncome(income = item)
                }
                Spacer(modifier = Modifier.height(20.dp))
            } else {
                for (item in arrayListOfExpence) {
                    ViewOfExpence(expence = item)
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }

        ExpenceOrIncomeButton(
            modifier = Modifier
                .size(70.dp)
                .align(Alignment.BottomEnd)
                .padding(12.dp)
        ) {
            onButtonClick()
        }
    }


}