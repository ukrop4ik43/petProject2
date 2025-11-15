package com.pettpro.expenceche.presentation.registration.model

import com.pettpro.domain.db.model.User

data class RegisterState(
    val login:String="",
    val loginError:String? =null,
    val password:String="",
    val passwordError:String? =null,
    val secondPassword:String="",
    val secondPasswordError:String? =null,
    val name:String="",
    val nameError:String? =null,
    var userList: List<User> = listOf()

)
