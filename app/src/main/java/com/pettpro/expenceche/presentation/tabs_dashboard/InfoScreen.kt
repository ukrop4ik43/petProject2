package com.pettpro.expenceche.presentation.tabs_dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pettpro.domain.home.TypeOfContentInDashBoardTab


@Composable
fun InfoScreen(dataForTheChart: Map<String, Int>, onClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        PieChart(
            dataForTheChart
        )
        ExpenceOrIncomeButton(
            modifier = Modifier
                .size(70.dp)
                .align(Alignment.BottomEnd)
                .padding(12.dp)
        ) {
            onClick()
        }
    }


}