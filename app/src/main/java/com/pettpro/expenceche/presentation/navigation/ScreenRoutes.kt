package com.pettpro.expenceche.presentation.navigation

enum class Screen {
    HOME,
    LOGIN,
    WELCOME,
    REGISTER
}
sealed class NavigationItem(val route: String) {
    data object Home : NavigationItem(Screen.HOME.name)

    data object Welcome : NavigationItem(Screen.WELCOME.name)
    data object Login : NavigationItem(Screen.LOGIN.name)
    data object Register : NavigationItem(Screen.REGISTER.name)
}