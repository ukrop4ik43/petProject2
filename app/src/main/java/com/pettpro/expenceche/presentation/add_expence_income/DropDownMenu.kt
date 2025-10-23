package com.pettpro.expenceche.presentation.add_expence_income

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text

import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.TextField

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.pettpro.domain.add_expence_income.model.categoryOfExpence
import com.pettpro.domain.add_expence_income.model.categoryOfIncome
import com.pettpro.domain.home.TypeOfContentInDashBoardTab
import com.pettpro.expenceche.presentation.add_expence_income.model.AddExpenceIncomeEvent
import com.pettpro.expenceche.presentation.colors.YellowCustom
import com.pettpro.expenceche.presentation.colors.yellowBackgroundBrush

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenu(
    typeOfContentInDashBoardTab: TypeOfContentInDashBoardTab?,
    viewModel: AddexpenceViewModel
) {
    var textfieldSize by remember { mutableStateOf(Size.Zero) }
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember {
        mutableStateOf(
            if (typeOfContentInDashBoardTab == TypeOfContentInDashBoardTab.Incomes) {
                categoryOfIncome[0].toString()
            } else {
                categoryOfExpence[0].toString()
            }
        )
    }
    viewModel.onEvent(AddExpenceIncomeEvent.SetTypeOfMoneyFlow(typeOfContentInDashBoardTab!!))

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ExposedDropdownMenuBox(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(horizontal = 20.dp),
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(

                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,

                    ),
                value = selectedText,
                textStyle = LocalTextStyle.current.copy(
                    fontSize = 32.sp,
                    textAlign = TextAlign.Start
                ),
                onValueChange = {
                    if (typeOfContentInDashBoardTab == TypeOfContentInDashBoardTab.Incomes) {
                        viewModel.onEvent(AddExpenceIncomeEvent.CategoryIncomeChange(it))
                    } else {

                        viewModel.onEvent(AddExpenceIncomeEvent.CategoryExpenceChange(it))
                    }
                },
                modifier = Modifier

                    .menuAnchor()
                    .fillMaxWidth()
                    .height(70.dp)
                    .onGloballyPositioned { coordinates ->
                        textfieldSize = coordinates.size.toSize()
                    }
                    .background(yellowBackgroundBrush, shape = RoundedCornerShape(10.dp)),
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            )
            MaterialTheme(
                colors = MaterialTheme.colors.copy(surface = Color.Transparent),
                shapes = MaterialTheme.shapes.copy(medium = RoundedCornerShape(5))
            ) {
                ExposedDropdownMenu(
                    modifier = Modifier
                        .background(YellowCustom)
                        .width(with(LocalDensity.current) { textfieldSize.width.toDp() })
                        .align(Alignment.Center),
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {

                    if (typeOfContentInDashBoardTab == TypeOfContentInDashBoardTab.Incomes) {
                        categoryOfIncome.forEach { item ->
                            DropdownMenuItem(

                                text = {
                                    TextElementOfDropdownMenu(item.toString())
                                },
                                onClick = {
                                    viewModel.onEvent(
                                        AddExpenceIncomeEvent.CategoryIncomeChange(
                                            item.toString()
                                        )
                                    )

                                    selectedText = item.toString()
                                    expanded = false
                                }
                            )
                        }
                    } else {
                        categoryOfExpence.forEach { item ->
                            DropdownMenuItem(

                                text = {
                                    TextElementOfDropdownMenu(item.toString())
                                },
                                onClick = {
                                    viewModel.onEvent(
                                        AddExpenceIncomeEvent.CategoryExpenceChange(
                                            item.toString()
                                        )
                                    )
                                    selectedText = item.toString()
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun TextElementOfDropdownMenu(item: String) {
    Text(
        text = item, textAlign = TextAlign.Start, modifier =
        Modifier
            .background(
                Color.Transparent
            ), style = TextStyle.Default.copy(
            fontSize = 22.sp
        )
    )
}