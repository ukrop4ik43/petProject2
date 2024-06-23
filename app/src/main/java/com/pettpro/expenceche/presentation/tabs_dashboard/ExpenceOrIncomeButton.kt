package com.pettpro.expenceche.presentation.tabs_dashboard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pettpro.expenceche.presentation.colors.DarkGrey200
import com.pettpro.expenceche.presentation.colors.YellowCustom
import com.pettpro.expenceche.presentation.colors.YellowCustomSecond


@Composable
fun ExpenceOrIncomeButton(modifier: Modifier) {

    FloatingActionButton(
        containerColor = DarkGrey200,

        onClick = { },
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