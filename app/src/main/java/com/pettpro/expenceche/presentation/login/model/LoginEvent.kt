package com.pettpro.expenceche.presentation.login.model

sealed class LoginEvent {
    data class LoginChange(val login: String) : LoginEvent()
    data class PasswordChange(val password: String) : LoginEvent()
    data class ShowToast(val text: String) : LoginEvent()
    data object NoConnection : LoginEvent()
    data object Sumbit : LoginEvent()
}