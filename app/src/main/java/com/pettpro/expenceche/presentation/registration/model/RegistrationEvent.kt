package com.pettpro.expenceche.presentation.registration.model

sealed interface RegistrationEvent {
    data class LoginChange(val login:String):RegistrationEvent
    data class PasswordChange(val password:String):RegistrationEvent
    data class NameChange(val name:String):RegistrationEvent

    data class ShowToast(val text:String):RegistrationEvent

    data object AddUser : RegistrationEvent
    data class PasswordRepeatChange(val passwordRepeat:String):RegistrationEvent
    object Sumbit:RegistrationEvent
}