package com.pettpro.domain.db.model

data class Income(
    val id:String,
    val date:String,
    val amount:Double,
    val category: CategoryOfIncome
)