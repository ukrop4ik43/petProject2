package com.pettpro.data.repository.db.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pettpro.domain.db.model.CategoryOfExpence
import com.pettpro.domain.db.model.Expence

class UserConvertor {
    private val gson = Gson()

    @TypeConverter
    fun fromArrayList(value: ArrayList<Expence>?): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toArrayList(value: String?): ArrayList<Expence>? {
        val type = object : TypeToken<ArrayList<Expence>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromCategory(category: CategoryOfExpence?): String? {
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
}