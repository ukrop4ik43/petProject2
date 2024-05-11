package com.pettpro.domain.usecases.userdb

import com.pettpro.domain.db.UserRepository
import com.pettpro.domain.db.model.User
import javax.inject.Inject

class UserDatabaseUseCases @Inject constructor(
     private val userRepository: UserRepository
) {
    suspend fun saveUser(user: User) {
        userRepository.saveUser(user)
    }

    fun getUser(): User {
       return userRepository.getUser()
    }

    suspend fun updateUser(user: User)  {
        return userRepository.updateUser(user)
    }

    suspend fun deleteUser()  {
        return userRepository.deleteUser()
    }
}