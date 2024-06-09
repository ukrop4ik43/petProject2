package com.pettpro.domain.login.model

data class LoginValidationResults (
    val successful:Boolean,
    val errorMessage:String? =null
)