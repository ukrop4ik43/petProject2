package com.pettpro.domain.db

import com.pettpro.domain.db.model.User

interface UserRepository {
    suspend fun saveUser(user: User)
    fun getUser():User
    suspend fun updateUser(user: User)
    suspend fun deleteUser()
}