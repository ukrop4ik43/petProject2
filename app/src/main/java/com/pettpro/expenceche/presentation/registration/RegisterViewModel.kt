package com.pettpro.expenceche.presentation.registration

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.FirebaseApp
import com.pettpro.domain.db.model.User
import com.pettpro.domain.registration.FirebaseUsersRegistrationRepository
import com.pettpro.domain.registration.RegistrationVerifyingRepository
import com.pettpro.domain.registration.ToastControl
import com.pettpro.expenceche.presentation.registration.model.RegisterDataState
import com.pettpro.expenceche.presentation.registration.model.RegistrationFormEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registrationVerifyingRepository: RegistrationVerifyingRepository,
    private val toastControl: ToastControl,
    private val getAllUsersRepository: FirebaseUsersRegistrationRepository
) : ViewModel() {
    @SuppressLint("MutableCollectionMutableState")
    var userList: MutableList<User> = mutableListOf()

    var state by mutableStateOf(RegisterDataState())
    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    init {
        viewModelScope.launch {
            userList = getAllUsersRepository.getResponseFromRealtimeDatabaseUsingCoroutines()
        }
    }

    fun onEvent(event: RegistrationFormEvent) {
        when (event) {
            is RegistrationFormEvent.LoginChange -> {
                state = state.copy(login = event.login)
            }
            is RegistrationFormEvent.PasswordChange -> {
                state = state.copy(password = event.password)
            }

            is RegistrationFormEvent.PasswordRepeatChange -> {
                state = state.copy(secondPassword = event.passwordRepeat)
            }

            is RegistrationFormEvent.NameChange -> {
                state = state.copy(name = event.name)
            }

            is RegistrationFormEvent.ShowToast -> {
                toastControl.show(event.text)
            }

            is RegistrationFormEvent.Sumbit -> {
                submitData()
            }

            is RegistrationFormEvent.AddUser -> {
                getAllUsersRepository.addUser(
                    User("",
                        state.name, state.login, state.password,
                        arrayListOf()
                    )
                )
            }
        }
    }


    private fun submitData() {
        val nameResult = registrationVerifyingRepository.checkName(state.name)
        val loginResult = registrationVerifyingRepository.checkLogin(state.login, userList)
        val passwordResult = registrationVerifyingRepository.checkPassword(state.password)
        val repeatedPasswordResult = registrationVerifyingRepository.checkRepeatedPassword(
            state.password,
            state.secondPassword
        )
        val hasError = listOf(
            nameResult,
            loginResult,
            passwordResult,
            repeatedPasswordResult
        ).any { !it.successful }

        if (hasError) {
            state = state.copy(
                nameError = nameResult.errorMessage,
                loginError = loginResult.errorMessage,
                passwordError = passwordResult.errorMessage,
                secondPasswordError = repeatedPasswordResult.errorMessage,
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