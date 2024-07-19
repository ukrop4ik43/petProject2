package com.pettpro.data.repository.tabs_dashboard

import com.pettpro.domain.db.model.Expence
import com.pettpro.domain.db.model.Income
import com.pettpro.domain.tabs_dashboard.ChartDataExtractor
import javax.inject.Inject

class ChartDataExtractorImpl @Inject constructor() : ChartDataExtractor {
    override fun dataForIncome(arrayOfIncome: ArrayList<Income>): Map<String, Int> {
        val categories = arrayListOf(
            "P2P",
            "Replenishment",
            "Other"
        )

        return mapOf(
            totalOfCategoryIncome(categories[0], arrayOfIncome),
            totalOfCategoryIncome(categories[1], arrayOfIncome),
            totalOfCategoryIncome(categories[2], arrayOfIncome)
        )

    }

    override fun dataForExpence(arrayOfExpence: ArrayList<Expence>): Map<String, Int> {
        val categories = arrayListOf(
            "Grocery",
            "Electronic",
            "Healthcare",
            "Transport",
            "Restaurants",
            "Entertainment",
            "Other"
        )

        return mapOf(
            totalOfCategoryExpence(categories[0], arrayOfExpence),
            totalOfCategoryExpence(categories[1], arrayOfExpence),
            totalOfCategoryExpence(categories[2], arrayOfExpence),
            totalOfCategoryExpence(categories[3], arrayOfExpence),
            totalOfCategoryExpence(categories[4], arrayOfExpence),
            totalOfCategoryExpence(categories[5], arrayOfExpence),
            totalOfCategoryExpence(categories[6], arrayOfExpence)
        )
    }

    private fun totalOfCategoryExpence(
        category: String,
        arrayOfIncome: ArrayList<Expence>
    ): Pair<String, Int> {
        var total = 0.0
        for (item in arrayOfIncome) {
            if (item.category == category) {
                total += item.amount
            }
        }
        return Pair(category, total.toInt())
    }


    private fun totalOfCategoryIncome(
        category: String,
        arrayOfIncome: ArrayList<Income>
    ): Pair<String, Int> {
        var total = 0.0
        for (item in arrayOfIncome) {
            if (item.category == category) {
                total += item.amount
            }
        }
        return Pair(category, total.toInt())
    }

    override fun totalIncome(arrayOfIncome: ArrayList<Income>): Double {
        var totalIncome = 0.0
        for (incomeItem in arrayOfIncome) {
            totalIncome += incomeItem.amount
        }
        return totalIncome
    }

    override fun totalExpence(arrayOfExpence: ArrayList<Expence>): Double {
        var totalExpence = 0.0
        for (expenceItem in arrayOfExpence) {
            totalExpence += expenceItem.amount
        }
        return totalExpence
    }
}