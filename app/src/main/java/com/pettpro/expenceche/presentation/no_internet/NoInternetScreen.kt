package com.pettpro.expenceche.presentation.no_internet

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.pettpro.expenceche.presentation.colors.YellowCustom
import com.pettpro.expenceche.presentation.colors.blackGradient
import com.pettpro.expenceche.presentation.colors.yellowBackgroundBrush
import com.pettpro.expenceche.presentation.navigation.NavigationItem


@Composable
fun NoInternetScreen(navController: NavHostController?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = yellowBackgroundBrush)
    ) {

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .padding(top = 60.dp),
            text = "No Internet connection\n\nPlease check your connection and",
            fontSize = 30.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            color = Color.DarkGray
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(top = 40.dp)
                .fillMaxWidth()
                .height(80.dp)
                .padding(bottom = 20.dp)
                .background(YellowCustom, shape = RoundedCornerShape(10.dp))
                .wrapContentHeight()
                .clickable {
                    navController?.navigate(NavigationItem.Login.route)
                },
            text = "Try again",
            textAlign = TextAlign.Center,
            style = TextStyle.Default.copy(
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                color = Color.DarkGray
            )

        )
    }
}