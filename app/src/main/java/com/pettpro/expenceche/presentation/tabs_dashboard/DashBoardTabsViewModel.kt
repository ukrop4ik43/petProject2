package com.pettpro.expenceche.presentation.tabs_dashboard

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pettpro.domain.db.model.User
import com.pettpro.domain.home.HomeScreenProvider
import com.pettpro.domain.usecases.userdb.UserDatabaseUseCases
import com.pettpro.domain.home.HomeScreenState
import com.pettpro.domain.home.TypeOfContentInDashBoardTab
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
    private val homeScreenStateProvider: HomeScreenProvider
) : ViewModel() {
    private val _screenState = MutableStateFlow<HomeScreenState>(HomeScreenState.Starting)
    val screenState: StateFlow<HomeScreenState> = _screenState.asStateFlow()


    private val _user = MutableStateFlow(User())
    val user: StateFlow<User> = _user.asStateFlow()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                Log.d("dasdas", "getted from database ${userDatabaseUseCases.getUser()}")
                _user.value = userDatabaseUseCases.getUser()
                delay(2000)
            }

        }
    }

    fun fetchData(typeOfContent: TypeOfContentInDashBoardTab, user: User) {
        _screenState.value = homeScreenStateProvider.getStateOfHomeScreen(typeOfContent, user)
    }

    fun addExpenceOrIncome(typeOfContent: TypeOfContentInDashBoardTab) {
        _screenState.value = HomeScreenState.AddUser(typeOfContent)

    }

}