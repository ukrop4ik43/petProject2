package com.pettpro.expenceche.presentation.registration

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pettpro.domain.db.model.User
import com.pettpro.domain.registration.FirebaseUsersRegistrationRepository
import com.pettpro.domain.registration.RegistrationVerifyingRepository
import com.pettpro.domain.registration.ToastControl
import com.pettpro.expenceche.presentation.registration.model.RegisterState
import com.pettpro.expenceche.presentation.registration.model.RegistrationEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registrationVerifyingRepository: RegistrationVerifyingRepository,
    private val toastControl: ToastControl,
    private val firebaseUsersRepository: FirebaseUsersRegistrationRepository
) : ViewModel() {
    var state by mutableStateOf(RegisterState())
    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    init {
        viewModelScope.launch {
            val newList=firebaseUsersRepository.getResponseFromRealtimeDatabaseUsingCoroutines()
            state=state.copy( userList = newList)
        }
    }

    fun onEvent(event: RegistrationEvent) {
        when (event) {
            is RegistrationEvent.LoginChange -> {
                state = state.copy(login = event.login)
            }
            is RegistrationEvent.PasswordChange -> {
                state = state.copy(password = event.password)
            }

            is RegistrationEvent.PasswordRepeatChange -> {
                state = state.copy(secondPassword = event.passwordRepeat)
            }

            is RegistrationEvent.NameChange -> {
                state = state.copy(name = event.name)
            }

            is RegistrationEvent.ShowToast -> {
                toastControl.show(event.text)
            }

            is RegistrationEvent.Sumbit -> {
                submitData()
            }

            is RegistrationEvent.AddUser -> {
                firebaseUsersRepository.addUser(
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
        val loginResult = registrationVerifyingRepository.checkLogin(state.login, state.userList)
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