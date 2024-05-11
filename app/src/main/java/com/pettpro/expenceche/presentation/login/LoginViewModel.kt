package com.pettpro.expenceche.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
) : ViewModel() {
    var loginTextFieldState by mutableStateOf(
        ""
    )

    var passwordTextFieldState by mutableStateOf(
        ""
    )
}