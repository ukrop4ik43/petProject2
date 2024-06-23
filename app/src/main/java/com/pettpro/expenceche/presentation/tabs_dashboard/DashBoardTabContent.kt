package com.pettpro.expenceche.presentation.tabs_dashboard

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.pettpro.domain.db.model.User
import com.pettpro.domain.home.HomeScreenState
import com.pettpro.domain.home.TypeOfContentInDashBoardTab

@Composable
fun TabContent(
    typeOfContent: TypeOfContentInDashBoardTab, viewModel: DashBoardTabsViewModel = hiltViewModel()
) {
    val user by viewModel.user.collectAsState()
    val screenState by viewModel.screenState.collectAsState()

    when (screenState) {
        is HomeScreenState.Starting -> {
            Log.d("dasdas", "starting")
            LoadingElementOnDashboard()
            LaunchedEffect(screenState) {
                viewModel.fetchData(
                    typeOfContent,
                    User(
                        user.id, user.name, user.login, user.password,
                        user.arrayOfExpence, user.arrayOfIncomes
                    )
                )
            }
        }

        is HomeScreenState.Loading -> {
            Log.d("dasdas", "loading")
            LoadingElementOnDashboard()
        }

        is HomeScreenState.NoInfo -> {
            Log.d("dasdas", "no info")
            NoInfoScreen(typeOfContent)
        }

        is HomeScreenState.ReadyToShow -> {
            Log.d("dasdas", "ready")
            (screenState as HomeScreenState.ReadyToShow).info
        }
    }
}
