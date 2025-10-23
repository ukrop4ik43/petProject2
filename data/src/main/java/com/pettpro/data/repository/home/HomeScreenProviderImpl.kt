package com.pettpro.data.repository.home

import com.pettpro.domain.db.model.User
import com.pettpro.domain.home.HomeScreenProvider
import com.pettpro.domain.home.HomeScreenState
import com.pettpro.domain.home.TypeOfContentInDashBoardTab
import javax.inject.Inject

class HomeScreenProviderImpl @Inject constructor() : HomeScreenProvider {
    override fun getStateOfHomeScreen(
        typeOfContent: TypeOfContentInDashBoardTab,
        user: User
    ): HomeScreenState {
        return when(typeOfContent) {
            TypeOfContentInDashBoardTab.Expences ->{
                checkForExpences(user)
            }

            TypeOfContentInDashBoardTab.Incomes ->{
                checkForIncomes(user)
            }
        }
    }

     private fun checkForExpences(user: User): HomeScreenState {
         return if(user.arrayOfExpence.isEmpty()){
             HomeScreenState.NoInfo
         }else{
             HomeScreenState.ReadyToShow
         }
    }

    private fun checkForIncomes(user: User): HomeScreenState {
        return if(user.arrayOfIncomes.isEmpty()){
            HomeScreenState.NoInfo
        }else{
            HomeScreenState.ReadyToShow
        }
    }
}