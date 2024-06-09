package com.pettpro.data.repository.db

import com.pettpro.data.repository.db.dao.UserDao
import com.pettpro.data.repository.db.mapper.toEntity
import com.pettpro.domain.db.UserRepository
import com.pettpro.domain.db.model.User

class UserRepositoryImpl(
    private val database: UserDao
) : UserRepository {

    override suspend fun saveUser(user: User) {
        database.insertUser(user.toEntity())
    }

    override fun getUser(): User {
        val user = database.getUser()
        return User(user?.id ?: "", user?.name ?: "", user?.login ?: "",
            user?.password ?: "", user?.arrayOfExpence ?: arrayListOf()
        )
    }

    override suspend fun updateUser(user: User) {
        database.updateUser(user.toEntity())
    }

    override suspend fun deleteUser() {
        database.deleteUser()
    }
}