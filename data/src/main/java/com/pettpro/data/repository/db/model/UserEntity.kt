package com.pettpro.data.repository.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pettpro.domain.db.model.Expence
import com.pettpro.domain.db.model.Income

@Entity(tableName = "user_saved")
data class UserEntity(
    @PrimaryKey val id: String,
    val name: String,
    val login: String,
    val password: String,
    val arrayOfExpence: ArrayList<Expence>,
    val arrayOfIncomes: ArrayList<Income>
)
