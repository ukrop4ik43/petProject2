package com.pettpro.domain.registration.model

data class RegistrationValidationResults (
    val successful:Boolean,
    val errorMessage:String? =null
)