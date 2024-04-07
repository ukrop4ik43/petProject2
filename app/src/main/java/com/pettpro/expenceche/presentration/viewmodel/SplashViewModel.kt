package com.pettpro.expenceche.presentration.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pettpro.domain.usecases.GetOnBoardingStateUseCase
import com.pettpro.domain.usecases.SaveOnBoardingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getOnBoardingStateUseCase: GetOnBoardingStateUseCase,
    private val saveOnBoardingUseCase: SaveOnBoardingUseCase
) : ViewModel() {
    fun saveOnBoardingState(completed: Boolean) {
        saveOnBoardingUseCase.invoke(completed)
    }

    fun getOnBoardingState(): Boolean {
        return getOnBoardingStateUseCase.invoke()
    }

}