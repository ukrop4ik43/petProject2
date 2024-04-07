package com.pettpro.domain.splashstorage

import kotlinx.coroutines.flow.Flow


interface SplashStorage {
     fun saveOnBoardingState(completed: Boolean)
    fun readOnBoardingState(): Boolean
}