package com.pettpro.data.repository.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.pettpro.data.repository.db.model.UserEntity
import com.pettpro.domain.db.model.User

@Dao
interface  UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: UserEntity)

    //read users
    @Query("SELECT * FROM user_saved")
    fun getUser(): UserEntity?

    //update user
    @Update
    suspend fun updateUser(user: UserEntity)

    //deleteAll
    @Query("DELETE  FROM user_saved")
    suspend fun deleteUser()

}
