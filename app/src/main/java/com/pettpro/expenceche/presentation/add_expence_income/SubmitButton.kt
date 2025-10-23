package com.pettpro.expenceche.presentation.add_expence_income

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pettpro.expenceche.presentation.colors.YellowCustomSecond

@Composable
fun SubmitButton(function: () -> Unit) {
    Text(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(top = 40.dp)

            .fillMaxWidth()
            .height(80.dp)
            .padding(bottom = 20.dp)
            .background(YellowCustomSecond, shape = RoundedCornerShape(20.dp))
            .wrapContentHeight()
            .clickable {
                function()
            },
        text = "Submit",
        textAlign = TextAlign.Center,
        style = TextStyle.Default.copy(
            fontSize = 28.sp,
            textAlign = TextAlign.Center,
            color = Color.DarkGray
        )
    )
}