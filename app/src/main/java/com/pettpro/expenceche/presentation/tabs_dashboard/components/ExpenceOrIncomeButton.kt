package com.pettpro.expenceche.presentation.tabs_dashboard.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pettpro.expenceche.presentation.colors.DarkGrey200
import com.pettpro.expenceche.presentation.colors.YellowCustom


@Composable
fun ExpenceOrIncomeButton(modifier: Modifier, onClick: () -> Unit) {

    FloatingActionButton(
        containerColor = DarkGrey200,

        onClick = { onClick() },
        modifier = modifier,
        shape = CircleShape,
    ) {
        Icon(
            Icons.Filled.Add,
            contentDescription = "content description",
            modifier = Modifier.size(30.dp),
            tint = YellowCustom
        )
    }


}