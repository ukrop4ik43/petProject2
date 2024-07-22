package com.pettpro.expenceche.presentation.tabs_dashboard

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.pettpro.domain.db.model.User
import com.pettpro.domain.home.HomeScreenState
import com.pettpro.domain.home.TypeOfContentInDashBoardTab
import com.pettpro.expenceche.presentation.navigation.NavigationItem

@Composable
fun TabContent(
    typeOfContent: TypeOfContentInDashBoardTab,
    navController: NavHostController?,
    viewModel: DashBoardTabsViewModel = hiltViewModel()
) {
    val user by viewModel.user.collectAsState()
    val screenState by viewModel.screenState.collectAsState()

    when (screenState) {
        is HomeScreenState.Starting -> {

            Log.d("dasdas", "starting")
            LoadingElementOnDashboard { viewModel.addExpenceOrIncome(typeOfContent) }
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
            LoadingElementOnDashboard { viewModel.addExpenceOrIncome(typeOfContent) }
        }

        is HomeScreenState.NoInfo -> {
            Log.d("dasdas", "no info")
            NoInfoScreen(typeOfContent) { viewModel.addExpenceOrIncome(typeOfContent) }
        }

        is HomeScreenState.ReadyToShow -> {

            InfoScreen(viewModel.getDataForTheChart(typeOfContent)) {
                viewModel.addExpenceOrIncome(
                    typeOfContent
                )
            }

        }

        is HomeScreenState.AddUser -> {
            navController?.navigate(NavigationItem.AddExpenceIncome.createRoute(typeOfContent))
        }
    }
    viewModel.getUserData()
}
