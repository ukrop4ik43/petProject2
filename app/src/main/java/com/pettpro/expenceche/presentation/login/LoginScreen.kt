package com.pettpro.expenceche.presentation.login

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.pettpro.expenceche.presentation.colors.YellowCustom
import com.pettpro.expenceche.presentation.colors.blackGradient
import com.pettpro.expenceche.presentation.colors.yellowBackgroundBrush
import com.pettpro.expenceche.presentation.login.model.LoginFormEvent
import com.pettpro.expenceche.presentation.navigation.NavigationItem

@Composable
fun LoginScreen(navController: NavHostController?, viewModel: LoginViewModel = hiltViewModel()) {

    val context = LocalContext.current
    val state = viewModel.state
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = yellowBackgroundBrush)
    ) {
        LaunchedEffect(key1 = context) {
            viewModel.validationEvents.collect { event ->
                when (event) {
                    is LoginViewModel.ValidationEvent.Success -> {
                        viewModel.saveUserToDb()
                        viewModel.onEvent(LoginFormEvent.ShowToast("Login successful"))
                        navController?.navigate(NavigationItem.Home.route)
                    }
                }
            }
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .padding(top = 60.dp),
            text = "LOGIN",
            fontSize = 40.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            color = Color.DarkGray
        )
        Spacer(modifier = Modifier.height(50.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .padding(10.dp)
                .background(blackGradient, shape = RoundedCornerShape(20.dp))
                .border(
                    BorderStroke(2.dp, SolidColor(Color.Black)),
                    shape = RoundedCornerShape(20.dp)
                )
        ) {
            TextField(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .height(70.dp)
                    .background(Color.DarkGray, shape = RoundedCornerShape(10.dp)),
                value = state.login,
                isError = state.loginError != null,
                textStyle = TextStyle.Default.copy(fontSize = 28.sp, textAlign = TextAlign.Start),
                placeholder = {
                    Text(
                        "Login",
                        style = TextStyle.Default.copy(
                            fontSize = 28.sp,
                            textAlign = TextAlign.Start
                        )
                    )
                },
                onValueChange = {
                    viewModel.onEvent(LoginFormEvent.LoginChange(it))
                }, colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Color.Black,
                    focusedIndicatorColor = Transparent,
                    unfocusedIndicatorColor = Transparent
                )
            )

            TextField(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp)

                    .fillMaxWidth()
                    .height(70.dp)
                    .background(Color.DarkGray, shape = RoundedCornerShape(10.dp)),
                value = state.password,
                isError = state.passwordError != null,
                placeholder = {
                    Text(
                        "Password",
                        style = TextStyle.Default.copy(
                            fontSize = 28.sp,
                            textAlign = TextAlign.Start
                        )
                    )
                },
                textStyle = TextStyle.Default.copy(fontSize = 28.sp, textAlign = TextAlign.Start),
                onValueChange = {
                    viewModel.onEvent(LoginFormEvent.PasswordChange(it))
                }, colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Color.Black,
                    focusedIndicatorColor = Transparent,
                    unfocusedIndicatorColor = Transparent
                )
            )

            LoginButton(context) {

                if (state.loginError != null) {
                    viewModel.onEvent(LoginFormEvent.ShowToast(state.loginError))
                }
                if (state.passwordError != null) {
                    viewModel.onEvent(LoginFormEvent.ShowToast(state.passwordError))
                }
                viewModel.onEvent(
                    LoginFormEvent.Sumbit
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        LowerRow(navController)
    }
}

@Composable
private fun LowerRow(navController: NavHostController?) {

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 30.dp)
    ) {
        Text(
            modifier = Modifier

                .padding(top = 60.dp),
            text = "Don't have an account? ",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            color = Color.DarkGray
        )
        Text(
            modifier = Modifier
                .padding(top = 60.dp)
                .clickable {
                    navController?.navigate(NavigationItem.Register.route)
                },
            text = "Register",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            color = Color.Black
        )
    }
}

@Composable
private fun LoginButton(context: Context, function: () -> Unit) {
    Text(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(top = 40.dp)
            .fillMaxWidth()
            .height(80.dp)
            .padding(bottom = 20.dp)
            .background(YellowCustom, shape = RoundedCornerShape(10.dp))
            .wrapContentHeight()
            .clickable {
                function.invoke()
            },
        text = "Login",
        textAlign = TextAlign.Center,
        style = TextStyle.Default.copy(
            fontSize = 28.sp,
            textAlign = TextAlign.Center,
            color = Color.DarkGray
        )

    )
}

@Preview
@Composable
fun prev() {
    LoginScreen(navController = null)
}