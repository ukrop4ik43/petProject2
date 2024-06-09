package com.pettpro.domain.login

import com.pettpro.domain.db.model.User
import com.pettpro.domain.login.model.LoginValidationResults

interface LoginVerifyingRepository  {
    fun checkLogin(login:String,users:MutableList<User>): LoginValidationResults
    fun checkPassword(login:String,password: String, users: MutableList<User>): LoginValidationResults
}