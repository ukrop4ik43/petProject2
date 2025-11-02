package com.pettpro.expenceche.presentation.add_expence_income

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pettpro.domain.add_expence_income.ActualTimeRepository
import com.pettpro.domain.add_expence_income.AddExpenceIncomeVerifyingRepository
import com.pettpro.domain.db.model.Expence
import com.pettpro.domain.db.model.Income
import com.pettpro.domain.home.CategoriesMapper
import com.pettpro.domain.home.TypeOfContentInDashBoardTab
import com.pettpro.domain.registration.FirebaseUsersRegistrationRepository
import com.pettpro.domain.registration.ToastControl
import com.pettpro.domain.usecases.userdb.UserDatabaseUseCases
import com.pettpro.expenceche.presentation.add_expence_income.model.AddExpenceState
import com.pettpro.expenceche.presentation.add_expence_income.model.AddExpenceIncomeEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class AddexpenceViewModel @Inject constructor(
    private val categoriesMapper: CategoriesMapper,
    private val addExpenceIncomeVerifyingRepository: AddExpenceIncomeVerifyingRepository,
    private val firebaseUsersRegistrationRepository: FirebaseUsersRegistrationRepository,
    private val toastControl: ToastControl,
    private val userDatabaseUseCases: UserDatabaseUseCases,
    private val actualTimeRepository: ActualTimeRepository,
) : ViewModel() {
    private var isItIncome = false
    var state by mutableStateOf(AddExpenceState())

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()


    //its necessary to call this block code in custom function,not in init{}
    suspend fun initViewModel() {
        withContext(Dispatchers.IO) {
            state = state.copy(user = userDatabaseUseCases.getUser())
        }
    }

    fun onEvent(event: AddExpenceIncomeEvent) {
        when (event) {
            is AddExpenceIncomeEvent.AmountChange -> {
                state = state.copy(amount = event.amount)
            }

            is AddExpenceIncomeEvent.CategoryExpenceChange -> {
                state =
                    state.copy(categoryOfExpence = categoriesMapper.setExpenceCategory(event.category))
            }

            is AddExpenceIncomeEvent.CategoryIncomeChange -> {

                state =
                    state.copy(categoryOfIncome = categoriesMapper.setIncomeCategory(event.category))
            }

            is AddExpenceIncomeEvent.SetTypeOfMoneyFlow -> {
                isItIncome = event.type == TypeOfContentInDashBoardTab.Incomes
            }

            is AddExpenceIncomeEvent.ShowToast -> {
                toastControl.show(event.text)
            }

            is AddExpenceIncomeEvent.Submit -> {
                submitData()
            }

            is AddExpenceIncomeEvent.Final -> {
                finalOfSaving()
            }

        }
    }

    private fun addIncome() {
        val newUser = state.user
        newUser.arrayOfIncomes.add(
            Income(
                (state.user.arrayOfIncomes.size).toString(),
                actualTimeRepository.getActualTime(),
                state.amount.toDouble(),
                state.categoryOfIncome!!.toString()
            )
        )

        state = state.copy(user = newUser)
    }

    private fun addExpence() {
        val newUser = state.user
        newUser.arrayOfExpence.add(
            Expence(
                (state.user.arrayOfExpence.size).toString(),
                actualTimeRepository.getActualTime(),
                state.amount.toDouble(),
                state.categoryOfExpence!!.toString()
            )
        )
        state = state.copy(user = newUser)
    }

    private fun submitData() {
        val amountResult = addExpenceIncomeVerifyingRepository.checkAmount(state.amount)
        val hasError = listOf(
            amountResult
        ).any { !it.successful }
        if (hasError) {
            state = state.copy(
                amountError = amountResult.errorMessage,
            )
            return
        }
        viewModelScope.launch(Dispatchers.IO) {
            if (isItIncome) {
                addIncome()
            } else {
                addExpence()
            }
            userDatabaseUseCases.updateUser(state.user)
            firebaseUsersRegistrationRepository.updateUser(state.user)
        }

        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)
        }
    }

    private fun finalOfSaving() {

    }


    sealed class ValidationEvent {
        data object Success : ValidationEvent()

    }
}