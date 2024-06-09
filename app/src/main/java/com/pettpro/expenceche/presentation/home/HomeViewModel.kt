package com.pettpro.expenceche.presentation.home

import androidx.lifecycle.ViewModel
import com.pettpro.domain.usecases.userdb.UserDatabaseUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userDatabaseUseCases: UserDatabaseUseCases
): ViewModel() {

}