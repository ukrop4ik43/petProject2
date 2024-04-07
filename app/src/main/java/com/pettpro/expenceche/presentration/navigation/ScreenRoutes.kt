package com.pettpro.expenceche.presentration.navigation

enum class Screen {
    HOME,
    LOGIN,
    WELCOME
}
sealed class NavigationItem(val route: String) {
    data object Home : NavigationItem(Screen.HOME.name)

    data object Welcome : NavigationItem(Screen.WELCOME.name)
    data object Login : NavigationItem(Screen.LOGIN.name)
}