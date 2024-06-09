package com.pettpro.expenceche.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.pettpro.expenceche.R
import com.pettpro.expenceche.presentation.colors.yellowBackgroundBrush
import com.pettpro.expenceche.presentation.tabs.TabForHome


@Composable
fun HomeScreen(navController: NavHostController?) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = yellowBackgroundBrush)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(), horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painterResource(R.drawable.baseline_settings_24),
                    contentDescription = "",
                    modifier = Modifier
                        .height(90.dp)
                        .padding(vertical = 3.dp)
                        .padding(start = 7.dp)
                        .align(Alignment.CenterStart)
                )
                Text(
                    modifier = Modifier
                        .padding(top = 1.dp)
                        .align(Alignment.Center),
                    text = "Dashboard",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
            }
        }
        TabForHome()
    }
}

@Composable
fun TabContent2() {
    // Content for Tab 2
    Text("Content for Tab 2", modifier = Modifier.fillMaxSize())
}

@Preview
@Composable
fun show() {
    HomeScreen(navController = null)
}