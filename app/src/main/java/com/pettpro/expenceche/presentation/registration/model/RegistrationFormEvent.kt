package com.pettpro.expenceche.presentation.registration.model

sealed class RegistrationFormEvent {
    data class LoginChange(val login:String):RegistrationFormEvent()
    data class PasswordChange(val password:String):RegistrationFormEvent()
    data class NameChange(val name:String):RegistrationFormEvent()

    data class ShowToast(val text:String):RegistrationFormEvent()
    data class PasswordRepeatChange(val passwordRepeat:String):RegistrationFormEvent()
    object Sumbit:RegistrationFormEvent()
}