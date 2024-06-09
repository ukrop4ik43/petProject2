package com.pettpro.data.repository.registration

import com.pettpro.domain.db.model.User
import com.pettpro.domain.registration.RegistrationVerifyingRepository
import com.pettpro.domain.registration.model.RegistrationValidationResults
import javax.inject.Inject

class RegistrationVerifyingRepositoryImpl @Inject constructor() : RegistrationVerifyingRepository {
    override fun checkLogin(
        login: String,
        users: MutableList<User>
    ): RegistrationValidationResults {
        if (loginExists(login, users)) {
            return RegistrationValidationResults(
                false,
                "Account with such login exists"
            )
        }
        if (login.length < 8) {
            return RegistrationValidationResults(
                false,
                "Login is too short,should be at least 8 characters"
            )
        }
        return RegistrationValidationResults(true)
    }

    private fun loginExists(login: String, users: MutableList<User>): Boolean {
        for (userData in users) {
            if (userData.login == login) {
                return true
            }
        }
        return false
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
        if (name.isEmpty()) {
            return RegistrationValidationResults(false, "Please enter name")
        }
        if (name[0].isLowerCase()) {
            return RegistrationValidationResults(false, "First letter of name should be capital")
        }
        return RegistrationValidationResults(true)
    }
}