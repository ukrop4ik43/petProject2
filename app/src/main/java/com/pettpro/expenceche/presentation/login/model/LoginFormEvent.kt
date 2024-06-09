package com.pettpro.expenceche.presentation.login.model

sealed class LoginFormEvent {
    data class LoginChange(val login: String) : LoginFormEvent()
    data class PasswordChange(val password: String) : LoginFormEvent()
    data class ShowToast(val text: String) : LoginFormEvent()
    data object Sumbit : LoginFormEvent()
}