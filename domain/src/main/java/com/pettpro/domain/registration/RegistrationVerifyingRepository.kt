package com.pettpro.domain.registration

import com.pettpro.domain.db.model.User
import com.pettpro.domain.registration.model.RegistrationValidationResults

interface RegistrationVerifyingRepository {
    fun checkLogin(login:String,users:List<User>):RegistrationValidationResults
    fun checkPassword(password:String):RegistrationValidationResults
    fun checkRepeatedPassword(password:String,secondPassword:String):RegistrationValidationResults
    fun checkName(name:String): RegistrationValidationResults
}