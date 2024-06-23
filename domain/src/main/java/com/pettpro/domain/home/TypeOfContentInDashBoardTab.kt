package com.pettpro.domain.home

sealed interface TypeOfContentInDashBoardTab {
    data object Expences : TypeOfContentInDashBoardTab
    data object Incomes : TypeOfContentInDashBoardTab
}