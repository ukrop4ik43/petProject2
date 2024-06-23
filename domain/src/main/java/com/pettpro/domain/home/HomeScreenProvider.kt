package com.pettpro.domain.home

import com.pettpro.domain.db.model.User

interface HomeScreenProvider {
    fun getStateOfHomeScreen(typeOfContent: TypeOfContentInDashBoardTab,user: User): HomeScreenState

}