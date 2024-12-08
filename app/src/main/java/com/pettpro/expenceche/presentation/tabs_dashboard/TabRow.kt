package com.pettpro.expenceche.presentation.tabs_dashboard

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.pettpro.domain.home.HomeScreenState
import com.pettpro.domain.home.TypeOfContentInDashBoardTab
import com.pettpro.expenceche.presentation.colors.YellowCustom
import com.pettpro.expenceche.presentation.colors.blackGradient200
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabForHome(
    navController: NavHostController?,
    viewModel: DashBoardTabsViewModel = hiltViewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(
        initialPage = 0, initialPageOffsetFraction = 0f
    ) {
        2
    }
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            when (page) {
                0 ->         viewModel.getUserData(TypeOfContentInDashBoardTab.Expences)
                1 -> viewModel.getUserData(TypeOfContentInDashBoardTab.Incomes)

            }
        }

    }
    val tabTitles = listOf("Expences", "Incomes")
    TabRow(
        backgroundColor = YellowCustom,
        selectedTabIndex = pagerState.currentPage,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(50)), indicator = { tabPositions: List<TabPosition> ->
            Box {}
        }
    ) {
        tabTitles.forEachIndexed { index, title ->
            val selected = pagerState.currentPage == index
            Tab(

                modifier = if (selected) Modifier
                    .clip(RoundedCornerShape(50))
                    .background(
                        blackGradient200
                    )
                else Modifier
                    .clip(RoundedCornerShape(50))
                    .background(
                        YellowCustom
                    ),
                selected = selected,
                onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                text = {
                    if (selected) {
                        Text(
                            text = title,
                            color = YellowCustom,
                            fontWeight = FontWeight.Medium,
                            fontSize = 17.sp,
                        )
                    } else {
                        Text(
                            text = title,
                            color = Color.Black,
                            fontWeight = FontWeight.Medium,
                            fontSize = 17.sp,
                        )
                    }

                }
            )
        }
    }
    HorizontalPager(
        state = pagerState, modifier = Modifier.fillMaxSize()
    ) { page ->
        when (page) {
            0 -> TabContent(TypeOfContentInDashBoardTab.Expences, navController,viewModel)
            1 -> TabContent(TypeOfContentInDashBoardTab.Incomes, navController, viewModel)

        }
    }
}