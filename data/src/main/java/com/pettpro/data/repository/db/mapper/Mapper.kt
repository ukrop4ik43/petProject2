package com.pettpro.data.repository.db.mapper

import com.pettpro.data.repository.db.model.UserEntity
import com.pettpro.domain.db.model.User

fun User.toEntity() = UserEntity(
    id = id,
    name = name,
    login = login,
    password = password,
    arrayOfExpence = arrayOfExpence,
    arrayOfIncomes = arrayOfIncomes
)