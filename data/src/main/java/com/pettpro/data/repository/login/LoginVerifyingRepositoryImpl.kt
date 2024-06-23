package com.pettpro.data.repository.login

import com.pettpro.domain.db.model.User
import com.pettpro.domain.login.LoginVerifyingRepository
import com.pettpro.domain.login.model.LoginValidationResults
import com.pettpro.domain.registration.RegistrationVerifyingRepository
import com.pettpro.domain.registration.model.RegistrationValidationResults
import javax.inject.Inject

class LoginVerifyingRepositoryImpl @Inject constructor() : LoginVerifyingRepository {
    override fun checkLogin(
        login: String,
        users: MutableList<User>
    ): LoginValidationResults {
        if(!loginExists(login,users)){
            return LoginValidationResults(
                false,
                "Wrong login"
            )
        }
        return LoginValidationResults(true)
    }

    override fun getActualUserToSave(login: String, users: MutableList<User>): User {
        for (userData in users) {
            if (userData.login == login) {
                return userData
            }
        }
        return User()
    }

    private fun loginExists(login: String, users: MutableList<User>): Boolean {
        for (userData in users) {
            if (userData.login == login) {
                return true
            }
        }
        return false
    }

    override fun checkPassword(login:String,password: String, users: MutableList<User>): LoginValidationResults {
        if (password.isEmpty()) {
            return LoginValidationResults(false, "Password is empty")
        }
        for(userItem in users){
            if(userItem.login==login && userItem.password==password){
                return LoginValidationResults(true)
            }
        }
        return LoginValidationResults(false,"Wrong login or password")
    }

}