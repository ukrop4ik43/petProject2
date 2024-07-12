package com.pettpro.data.repository.db.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pettpro.domain.db.model.CategoryOfExpence
import com.pettpro.domain.db.model.CategoryOfIncome
import com.pettpro.domain.db.model.Expence
import com.pettpro.domain.db.model.Income

class UserConvertor {
    private val gson = Gson()
    @TypeConverter
    fun fromCategoryExpence(category: CategoryOfExpence?): String? {
        return category?.javaClass?.simpleName
    }

    @TypeConverter
    fun fromCategoryIncome(category: CategoryOfIncome?): String? {
        return category?.javaClass?.simpleName
    }

    @TypeConverter
    fun toCategory(value: String?): CategoryOfExpence? {
        return when (value) {
            "Grocery" -> CategoryOfExpence.Grocery
            "Electronic" -> CategoryOfExpence.Electronic
            "Healthcare" -> CategoryOfExpence.Healthcare
            "Transport" -> CategoryOfExpence.Transport
            "Restaurants" -> CategoryOfExpence.Restaurants
            "Entertainment" -> CategoryOfExpence.Entertainment

            "Other" -> CategoryOfExpence.Other
            else -> null
        }
    }


    @TypeConverter
    fun toCategoryIncome(value: String?): CategoryOfIncome? {
        return when (value) {
            "P2P" -> CategoryOfIncome.P2P
            "Replenishment" -> CategoryOfIncome.Replenishment
            "Other" -> CategoryOfIncome.Other
            else -> null
        }
    }
    @TypeConverter
    fun fromExpenceArrayList(value: ArrayList<Expence>?): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toArrayList(value: String?): ArrayList<Expence>? {
        val type = object : TypeToken<ArrayList<Expence>>() {}.type
        return gson.fromJson(value, type)
    }


    @TypeConverter
    fun fromIncomeArrayList(value: ArrayList<Income>?): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toArrayIncomeList(value: String?): ArrayList<Income>? {
        val type = object : TypeToken<ArrayList<Income>>() {}.type
        return gson.fromJson(value, type)
    }


}