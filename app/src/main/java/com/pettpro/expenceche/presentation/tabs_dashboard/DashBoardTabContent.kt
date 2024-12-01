package com.pettpro.expenceche.presentation.tabs_dashboard

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.pettpro.domain.db.model.User
import com.pettpro.domain.home.HomeScreenState
import com.pettpro.domain.home.TypeOfContentInDashBoardTab
import com.pettpro.expenceche.presentation.navigation.NavigationItem

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TabContent(
    typeOfContent: TypeOfContentInDashBoardTab,
    navController: NavHostController?,
    viewModel: DashBoardTabsViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val user by viewModel.user.collectAsState()
    val screenState by viewModel.screenState.collectAsState()
    LaunchedEffect(key1 = Unit) {
        viewModel.setState(HomeScreenState.Starting)
    }



    when (screenState) {
        is HomeScreenState.Starting -> {

            Log.d("dasdas", "starting")
            LoadingElementOnDashboard { viewModel.addExpenceOrIncome(typeOfContent) }
                viewModel.getUserData(typeOfContent)

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
            Log.d("dasdas", "ready to show,${user.arrayOfIncomes}")
            if ((typeOfContent == TypeOfContentInDashBoardTab.Expences && user.arrayOfExpence.size == 0) ||
                (typeOfContent == TypeOfContentInDashBoardTab.Incomes && user.arrayOfIncomes.size == 0)
            ) {
                NoInfoScreen(typeOfContent) { viewModel.addExpenceOrIncome(typeOfContent) }
            } else {
                InfoScreen(
                    typeOfContent,
                    user.arrayOfIncomes,
                    user.arrayOfExpence,
                    viewModel.getDataForTheChart(typeOfContent)
                ) {
                    viewModel.addExpenceOrIncome(
                        typeOfContent
                    )
                }
            }


        }

        is HomeScreenState.AddUser -> {
            navController?.navigate(NavigationItem.AddExpenceIncome.createRoute(typeOfContent))
        }
    }

}
