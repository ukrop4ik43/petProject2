package com.pettpro.expenceche.presentation.login


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pettpro.domain.db.model.User
import com.pettpro.domain.login.LoginVerifyingRepository
import com.pettpro.domain.registration.FirebaseUsersRegistrationRepository
import com.pettpro.domain.registration.ToastControl
import com.pettpro.domain.usecases.userdb.UserDatabaseUseCases
import com.pettpro.expenceche.presentation.login.model.LoginDataState
import com.pettpro.expenceche.presentation.login.model.LoginFormEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginVerifyingRepository: LoginVerifyingRepository,
    private val getAllUsersRepository: FirebaseUsersRegistrationRepository,
    private val toastControl: ToastControl,
    private val userDatabaseUseCases: UserDatabaseUseCases,

    ) : ViewModel() {
    @SuppressLint("MutableCollectionMutableState")
    var userList: MutableList<User> = mutableListOf()

    var state by mutableStateOf(LoginDataState())
    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    init {
        viewModelScope.launch {
            userList = getAllUsersRepository.getResponseFromRealtimeDatabaseUsingCoroutines()
        }
    }

    fun onEvent(event: LoginFormEvent) {
        when (event) {
            is LoginFormEvent.LoginChange -> {
                state = state.copy(login = event.login)
            }

            is LoginFormEvent.PasswordChange -> {
                state = state.copy(password = event.password)
            }

            is LoginFormEvent.ShowToast -> {
                toastControl.show(event.text)
            }

            is LoginFormEvent.Sumbit -> {
                submitData()
            }
        }
    }


    suspend fun saveUserToDb() {
        userDatabaseUseCases.deleteUser()
        Log.d(
            "dasdas", "saved ${
                loginVerifyingRepository.getActualUserToSave(
                    state.login,
                    userList
                )
            } "
        )
        userDatabaseUseCases.saveUser(
            loginVerifyingRepository.getActualUserToSave(
                state.login,
                userList
            )
        )
    }

    suspend fun updateUserInDb() {
        Log.d(
            "dasdas", "saved ${
                loginVerifyingRepository.getActualUserToSave(
                    state.login,
                    userList
                )
            } "
        )
        userDatabaseUseCases.updateUser(
            loginVerifyingRepository.getActualUserToSave(
                state.login,
                userList
            )
        )
        viewModelScope.launch(Dispatchers.IO) {
            Log.d(
                "dasdas", "getteduser ${userDatabaseUseCases.getUser()} "
            )
        }

    }

    private fun submitData() {
        val loginResult = loginVerifyingRepository.checkLogin(state.login, userList)
        val passwordResult =
            loginVerifyingRepository.checkPassword(state.login, state.password, userList)
        val hasError = listOf(
            loginResult, passwordResult
        ).any { !it.successful }
        if (hasError) {
            state = state.copy(
                loginError = loginResult.errorMessage,
                passwordError = passwordResult.errorMessage,
            )
            return
        }
        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)
        }
    }

    sealed class ValidationEvent {
        data object Success : ValidationEvent()

    }
}