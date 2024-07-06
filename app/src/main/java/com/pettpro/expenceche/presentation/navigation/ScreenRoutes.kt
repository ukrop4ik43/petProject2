package com.pettpro.expenceche.presentation.navigation

import com.pettpro.domain.home.TypeOfContentInDashBoardTab

enum class Screen {
    HOME,
    LOGIN,
    WELCOME,
    REGISTER,
    ADD_EXPENCE_INCOME
}

sealed class NavigationItem(val route: String) {
    data object Home : NavigationItem(Screen.HOME.name)

    data object Welcome : NavigationItem(Screen.WELCOME.name)
    data object Login : NavigationItem(Screen.LOGIN.name)
    data object Register : NavigationItem(Screen.REGISTER.name)

    data object AddExpenceIncome :
        NavigationItem("${Screen.ADD_EXPENCE_INCOME.name}/{typeOfContent}") {
        fun createRoute(type: TypeOfContentInDashBoardTab): String {
            val typeString = when (type) {
                is TypeOfContentInDashBoardTab.Expences -> "expences"
                is TypeOfContentInDashBoardTab.Incomes -> "incomes"
            }
            return "${Screen.ADD_EXPENCE_INCOME.name}/$typeString"
        }
    }
}