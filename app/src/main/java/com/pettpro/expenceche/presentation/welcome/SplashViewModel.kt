package com.pettpro.expenceche.presentation.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pettpro.domain.db.model.User
import com.pettpro.domain.usecases.onboarding.GetOnBoardingStateUseCase
import com.pettpro.domain.usecases.onboarding.SaveOnBoardingUseCase
import com.pettpro.domain.usecases.userdb.UserDatabaseUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getOnBoardingStateUseCase: GetOnBoardingStateUseCase,
    private val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    private val userDatabaseUseCases: UserDatabaseUseCases
) : ViewModel() {
    fun saveOnBoardingState(completed: Boolean) {
        saveOnBoardingUseCase.invoke(completed)
    }

    suspend fun saveUser(user: User) {
        userDatabaseUseCases.saveUser(user)
    }


    fun getUser() :User {
       return userDatabaseUseCases.getUser()
    }

    fun getOnBoardingState(): Boolean {
        return getOnBoardingStateUseCase.invoke()
    }

}