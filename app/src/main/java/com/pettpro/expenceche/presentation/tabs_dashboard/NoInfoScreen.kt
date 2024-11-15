package com.pettpro.expenceche.presentation.tabs_dashboard

import androidx.compose.foundation.background
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
import com.pettpro.expenceche.presentation.colors.DarkGrey200

@Composable
fun NoInfoScreen(typeOfContent: TypeOfContentInDashBoardTab,onClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Text(
            modifier = Modifier
                .padding(top = 1.dp)
                .align(Alignment.Center),
            text = if (typeOfContent == TypeOfContentInDashBoardTab.Incomes) {
                "There are no incomes yet..."
            } else {
                "There are no expences yet..."
            },
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            color = Color.Black
        )
        ExpenceOrIncomeButton(
            modifier = Modifier
                .size(70.dp)
                .align(Alignment.BottomEnd)
                .padding(12.dp)
        ){
            onClick()
        }
    }
}