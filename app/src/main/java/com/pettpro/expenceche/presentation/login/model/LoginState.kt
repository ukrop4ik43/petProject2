package com.pettpro.expenceche.presentation.login.model

data class LoginState(
    val login:String="",
    val loginError:String? =null,
    val password:String="",
    val passwordError:String? =null
)
