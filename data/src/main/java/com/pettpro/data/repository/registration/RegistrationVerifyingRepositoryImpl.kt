package com.pettpro.data.repository.registration

import com.pettpro.domain.registration.RegistrationVerifyingRepository
import com.pettpro.domain.registration.model.RegistrationValidationResults
import javax.inject.Inject

class RegistrationVerifyingRepositoryImpl @Inject constructor() : RegistrationVerifyingRepository {
    override fun checkLogin(login: String): RegistrationValidationResults {
        if (login.length < 8) {
            return RegistrationValidationResults(
                false,
                "Login is too short,should be at least 8 characters"
            )
        }
        return RegistrationValidationResults(true)
    }

    override fun checkPassword(password: String): RegistrationValidationResults {
        if (password.isEmpty()) {
            return RegistrationValidationResults(false, "Password is empty")
        }
        if (password.any { it.isDigit() } && password.any { it.isLetter() }) {
            return RegistrationValidationResults(
                false,
                "Password should contain letters and digits"
            )
        }
        return RegistrationValidationResults(true)
    }

    override fun checkRepeatedPassword(
        password: String,
        secondPassword: String
    ): RegistrationValidationResults {
        if (password != secondPassword) {
            return RegistrationValidationResults(false, "Passwords should be the same")
        }
        return RegistrationValidationResults(true)
    }

    override fun checkName(name: String): RegistrationValidationResults {
        if(name.isEmpty()){
            return RegistrationValidationResults(false, "Please enter name")
        }
        if (name[0].isLowerCase()) {
            return RegistrationValidationResults(false, "First letter of name should be capital")
        }
        return RegistrationValidationResults(true)
    }
}