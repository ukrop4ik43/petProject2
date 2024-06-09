package com.pettpro.domain.registration

import com.pettpro.domain.db.model.User

interface FirebaseUsersRegistrationRepository {
    suspend fun getResponseFromRealtimeDatabaseUsingCoroutines(): MutableList<User>
    fun addUser(user: User)

}