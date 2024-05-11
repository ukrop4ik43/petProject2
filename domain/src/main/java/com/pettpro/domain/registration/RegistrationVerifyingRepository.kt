package com.pettpro.domain.registration

import com.pettpro.domain.registration.model.RegistrationValidationResults

interface RegistrationVerifyingRepository {
    fun checkLogin(login:String):RegistrationValidationResults
    fun checkPassword(password:String):RegistrationValidationResults
    fun checkRepeatedPassword(password:String,secondPassword:String):RegistrationValidationResults
    fun checkName(name:String): RegistrationValidationResults
}