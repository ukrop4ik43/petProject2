package com.pettpro.domain.usecases

import com.pettpro.domain.splashstorage.SplashStorage
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetOnBoardingStateUseCase @Inject constructor(private val splashStorage: SplashStorage) {
    fun invoke(): Boolean {
        return splashStorage.readOnBoardingState()
    }
}