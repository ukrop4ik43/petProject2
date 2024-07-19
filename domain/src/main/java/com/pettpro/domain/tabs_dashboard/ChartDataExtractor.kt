package com.pettpro.domain.tabs_dashboard

import com.pettpro.domain.db.model.Expence
import com.pettpro.domain.db.model.Income

interface ChartDataExtractor {
    fun dataForIncome(arrayOfIncome:ArrayList<Income>):Map<String, Int>
    fun dataForExpence(arrayOfExpence:ArrayList<Expence>):Map<String, Int>
    fun totalIncome(arrayOfIncome:ArrayList<Income>):Double
    fun totalExpence(arrayOfExpence:ArrayList<Expence>):Double

}