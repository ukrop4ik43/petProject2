package com.pettpro.domain.db.model


data class User(
    val id: String = "",
    val name: String = "",
    val login: String = "",
    val password: String = "",
    val arrayOfExpence: ArrayList<Expence> = arrayListOf(),
    val arrayOfIncomes: ArrayList<Income> = arrayListOf()
)
