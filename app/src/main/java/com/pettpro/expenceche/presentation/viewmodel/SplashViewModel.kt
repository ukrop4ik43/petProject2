package com.pettpro.expenceche.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.pettpro.domain.usecases.GetOnBoardingStateUseCase
import com.pettpro.domain.usecases.SaveOnBoardingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
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