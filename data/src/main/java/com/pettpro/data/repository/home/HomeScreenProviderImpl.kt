package com.pettpro.data.repository.home

import android.util.Log
import com.pettpro.domain.db.model.User
import com.pettpro.domain.home.HomeScreenProvider
import com.pettpro.domain.home.HomeScreenState
import com.pettpro.domain.home.TypeOfContentInDashBoardTab
import com.pettpro.domain.login.LoginVerifyingRepository
import javax.inject.Inject

class HomeScreenProviderImpl @Inject constructor() : HomeScreenProvider {
    override fun getStateOfHomeScreen(
        typeOfContent: TypeOfContentInDashBoardTab,
        user: User
    ): HomeScreenState {
        Log.d("dasdassss", "return state ${typeOfContent}")
        return when(typeOfContent) {
            TypeOfContentInDashBoardTab.Expences ->{
                Log.d("dasdas", "expences")
                checkForExpences(user)
            }

            TypeOfContentInDashBoardTab.Incomes ->{
                Log.d("dasdas", "incomes")
                checkForIncomes(user)
            }
        }
    }

     private fun checkForExpences(user: User): HomeScreenState {
         return if(user.arrayOfExpence.size==0){
             HomeScreenState.NoInfo
         }else{
             HomeScreenState.ReadyToShow
         }
    }

    private fun checkForIncomes(user: User): HomeScreenState {
        return if(user.arrayOfIncomes.size==0){
            Log.d("dasdas", "no incomes")
            HomeScreenState.NoInfo
        }else{
            HomeScreenState.ReadyToShow
        }
    }
}