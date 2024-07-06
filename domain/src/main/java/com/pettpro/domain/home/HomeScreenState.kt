package com.pettpro.domain.home


sealed class HomeScreenState {

    data object Starting : HomeScreenState()
        data object Loading : HomeScreenState()
    data object NoInfo : HomeScreenState()

    data class ReadyToShow(val info:String ): HomeScreenState()

    data class AddUser(val typeOfContent:TypeOfContentInDashBoardTab) : HomeScreenState()
}