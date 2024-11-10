package com.pettpro.expenceche.presentation.tabs_dashboard

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pettpro.domain.db.model.User
import com.pettpro.domain.home.HomeScreenProvider
import com.pettpro.domain.usecases.userdb.UserDatabaseUseCases
import com.pettpro.domain.home.HomeScreenState
import com.pettpro.domain.home.TypeOfContentInDashBoardTab
import com.pettpro.domain.tabs_dashboard.ChartDataExtractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class DashBoardTabsViewModel @Inject constructor(
    private val userDatabaseUseCases: UserDatabaseUseCases,
    private val homeScreenStateProvider: HomeScreenProvider,
    private val chartDataExtractor: ChartDataExtractor
) : ViewModel() {
    private val _screenState = MutableStateFlow<HomeScreenState>(HomeScreenState.Starting)
    val screenState: StateFlow<HomeScreenState> = _screenState.asStateFlow()


    private val _user = MutableStateFlow(User())
    val user: StateFlow<User> = _user.asStateFlow()
    fun getUserData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val gettedUserData = userDatabaseUseCases.getUser()
                Log.d("dasdas", "getted from database ${gettedUserData}")
                _user.value = gettedUserData
            }
        }

    }

    fun getDataForTheChart(typeOfContent: TypeOfContentInDashBoardTab): Map<String, Int> {
        return if (typeOfContent == TypeOfContentInDashBoardTab.Incomes) {
            chartDataExtractor.dataForIncome(user.value.arrayOfIncomes)
        } else {
            chartDataExtractor.dataForExpence(user.value.arrayOfExpence)
        }
    }

    fun fetchData(typeOfContent: TypeOfContentInDashBoardTab, user: User) {
        Log.d("dasdas", "fetch data,type of content ${typeOfContent} , user ${user}")
        _screenState.value = homeScreenStateProvider.getStateOfHomeScreen(typeOfContent, user)
    }

    fun addExpenceOrIncome(typeOfContent: TypeOfContentInDashBoardTab) {
        _screenState.value = HomeScreenState.AddUser(typeOfContent)

    }

    fun setState(state: HomeScreenState) {
        _screenState.value = state
    }
}