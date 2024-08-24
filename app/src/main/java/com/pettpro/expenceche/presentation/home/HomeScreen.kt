package com.pettpro.expenceche.presentation.home

import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.pettpro.expenceche.R
import com.pettpro.expenceche.presentation.colors.yellowBackgroundBrush
import com.pettpro.expenceche.presentation.login.LoginViewModel
import com.pettpro.expenceche.presentation.navigation.NavigationItem
import com.pettpro.expenceche.presentation.tabs_dashboard.TabForHome
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Composable
fun HomeScreen(navController: NavHostController?, viewModel: HomeViewModel = hiltViewModel()) {
    LaunchedEffect(Unit) {
        launch(Dispatchers.IO) {
            Log.d("dassa", viewModel.getUser().toString())

        }

    }
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

                Text(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .height(50.dp)
                        .align(Alignment.Center),
                    text = "Dashboard",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
            }
        }
        TabForHome(navController)
    }
}


