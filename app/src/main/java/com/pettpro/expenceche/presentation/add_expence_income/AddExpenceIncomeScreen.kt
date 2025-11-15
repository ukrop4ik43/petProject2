package com.pettpro.expenceche.presentation.add_expence_income

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.pettpro.domain.home.TypeOfContentInDashBoardTab
import com.pettpro.expenceche.R
import com.pettpro.expenceche.presentation.add_expence_income.components.DropDownMenu
import com.pettpro.expenceche.presentation.add_expence_income.components.SubmitButton
import com.pettpro.expenceche.presentation.add_expence_income.model.AddExpenceIncomeEvent
import com.pettpro.expenceche.presentation.colors.DarkGrey200
import com.pettpro.expenceche.presentation.colors.YellowCustomSecond
import com.pettpro.expenceche.presentation.colors.blackGradient200
import com.pettpro.expenceche.presentation.colors.yellowBackgroundBrush
import com.pettpro.expenceche.presentation.navigation.NavigationItem

@Composable
fun AddExpenceIncomeScreen(
    navController: NavHostController?,
    typeOfContentInDashBoardTab: TypeOfContentInDashBoardTab?,
    viewModel: AddexpenceViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val context = LocalContext.current
    LaunchedEffect(true) {
        viewModel.initViewModel()
    }
    LaunchedEffect(key1 = context) {
        viewModel.validationEvents.collect { event ->
            when (event) {
                is AddexpenceViewModel.ValidationEvent.Success -> {
                    viewModel.onEvent(AddExpenceIncomeEvent.ShowToast("Successfully Added"))
                    navController?.navigate(NavigationItem.Home.route)
                }
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = blackGradient200)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(), horizontalArrangement = Arrangement.Start
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painterResource(R.drawable.baseline_arrow_back_24),
                    contentDescription = "",
                    modifier = Modifier
                        .height(70.dp)
                        .padding(vertical = 10.dp)
                        .padding(start = 7.dp)
                        .align(Alignment.CenterStart)
                        .clickable {
                            navController?.navigate(NavigationItem.Home.route)
                        }
                )
                Text(
                    modifier = Modifier
                        .padding(top = 1.dp)
                        .align(Alignment.Center),
                    text = "Add new ${typeOfContentInDashBoardTab.toString().toLowerCase()}",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    color = YellowCustomSecond
                )
            }
        }
        DropDownMenu(typeOfContentInDashBoardTab, viewModel)
        TextField(
            singleLine = true,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp)
                .fillMaxWidth()
                .height(70.dp)
                .background(yellowBackgroundBrush, shape = RoundedCornerShape(10.dp)),
            value = state.amount,
            isError = state.amountError != null,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    viewModel.onEvent(
                        AddExpenceIncomeEvent.Submit
                    )
                }
            ),
            placeholder = {
                Text(
                    "Amount...", style = TextStyle.Default.copy(
                        fontSize = 28.sp,
                        textAlign = TextAlign.Start,
                        color = DarkGrey200
                    )
                )
            },
            textStyle = TextStyle.Default.copy(fontSize = 28.sp, textAlign = TextAlign.Start),
            onValueChange = {
                viewModel.onEvent(AddExpenceIncomeEvent.AmountChange(it))
            }, colors = TextFieldDefaults.textFieldColors(
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        Column(
            modifier = Modifier
                .fillMaxSize(), verticalArrangement = Arrangement.Bottom
        ) {
            SubmitButton {
                if (state.amountError != null) {
                    viewModel.onEvent(AddExpenceIncomeEvent.ShowToast(state.amountError))
                }
                viewModel.onEvent(
                    AddExpenceIncomeEvent.Submit
                )
            }
        }
    }
}
