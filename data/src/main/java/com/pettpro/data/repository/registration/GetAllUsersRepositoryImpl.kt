package com.pettpro.data.repository.registration

import android.content.Context
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.pettpro.data.repository.registration.Constants.USERS_DB
import com.pettpro.domain.db.model.User
import com.pettpro.domain.registration.FirebaseUsersRegistrationRepository
import kotlinx.coroutines.tasks.await

class FirebaseUsersRegistrationRepositoryImpl(
    private val context: Context,
    private val rootRef: DatabaseReference = FirebaseDatabase.getInstance().reference,
    private val productRef: DatabaseReference = rootRef.child(USERS_DB)
) : FirebaseUsersRegistrationRepository {

    override suspend fun getResponseFromRealtimeDatabaseUsingCoroutines(): MutableList<User> {
        FirebaseApp.initializeApp(context)

        val response: MutableList<User> = productRef.get().await().children.map { snapShot ->
            snapShot.getValue(User::class.java)!!
        }.toMutableList()

        return response
    }

    override fun addUser(user: User) {

        val key: String = productRef.push().key.toString()
        rootRef.child("users").child(key).setValue(
            User(
                key,
                user.name,
                user.login,
                user.password,
                arrayListOf()
            )
        )

    }

}