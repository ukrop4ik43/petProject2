package com.pettpro.domain.db.model

data class Expence(
    val id:String,
    val date:String,
    val amount:Double,
    val category: CategoryOfExpence
)