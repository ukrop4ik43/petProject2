package com.pettpro.expenceche.presentation.tabs_dashboard.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pettpro.expenceche.presentation.colors.DarkGrey200


@Composable
fun LoadingElementOnDashboard(
    onClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(40.dp)
                .padding(top = 30.dp),
            color = DarkGrey200,
            strokeWidth = 4.dp
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