package com.assignment.onlinescoreupdateapp.presentation.fixures.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.assignment.onlinescoreupdateapp.domain.models.fixtures.FixtureInfoItem
import com.assignment.onlinescoreupdateapp.domain.models.fixtures.FixtureTeam
import com.assignment.onlinescoreupdateapp.presentation.common.TimeSchedulerManager
import com.assignment.onlinescoreupdateapp.presentation.composables.FixtureList
import com.assignment.onlinescoreupdateapp.presentation.composables.FixtureSearchField
import com.assignment.onlinescoreupdateapp.presentation.fixturedetails.routes.FixtureDetailsRoute
import com.assignment.onlinescoreupdateapp.presentation.fixures.states.FixtureState
import com.assignment.onlinescoreupdateapp.presentation.fixures.viewmodel.FixtureViewModel
import com.example.compose.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FixtureScreen(
    navController: NavController,
    fixtureState: State<FixtureState>,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Fixtures",
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            )
        })
    { innerPadding ->
        val query = rememberSaveable { mutableStateOf("") }
        val filteredItems = remember(query.value, fixtureState.value.data) {
            if (query.value.isBlank()) {
                fixtureState.value.data
            } else {
                fixtureState.value.data?.filter { item ->
                    item.firstTeam.name.contains(query.value, ignoreCase = true) ||
                            item.secondTeam.name.contains(query.value, ignoreCase = true)
                }
            }
        }
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(10.dp)
        ) {
            FixtureSearchField { searchQuery ->
                query.value = searchQuery
            }
            Spacer(modifier = Modifier.height(20.dp))
            fixtureState.value.apply {
                if (filteredItems != null) {
                    when {
                        filteredItems.isEmpty() -> {
                            Text(
                                text = "No fixtures found",
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
                            )
                        }

                        else -> {
                            FixtureList(
                                fixtureList = filteredItems
                            ) { fixtureInfo ->
                                navController.navigate(
                                    FixtureDetailsRoute(
                                        fixtureId = fixtureInfo.id
                                    )
                                )
                            }
                        }
                    }
                } else {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        when {
                            !errorMessage.isNullOrEmpty() && isError -> {
                                Text(
                                    text = errorMessage,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.error,
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                                )
                            }

                            isLoading -> {
                                CircularProgressIndicator(
                                    modifier = Modifier
                                        .align(Alignment.CenterHorizontally)
                                        .size(50.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FixtureScreenParent(
    navController: NavController,
    fixtureViewModel: FixtureViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = Unit) {
        fixtureViewModel.getFixtures()
    }
    DisposableEffect(key1 = Unit) {
        TimeSchedulerManager.startTimer {
            fixtureViewModel.getFixtures()
        }
        onDispose {
            TimeSchedulerManager.stopTimer()
        }
    }
    FixtureScreen(
        navController = navController,
        fixtureState = fixtureViewModel.fixtureStateFlow.collectAsStateWithLifecycle()
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun EmployerSearchScreenNightPreview() {
    AppTheme {
        Surface {
            FixtureScreen(
                fixtureState = remember {
                    mutableStateOf(
                        FixtureState(
                            isLoading = false,
                            isError = true,
                            errorMessage = "Something went wrong",
                            data = null
                        )
                    )
                },
                navController = rememberNavController()
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun EmployerSearchScreenPreview() {
    AppTheme {
        Surface {
            FixtureScreen(
                fixtureState = remember {
                    mutableStateOf(
                        FixtureState(
                            isLoading = false,
                            isError = false,
                            errorMessage = null,
                            data = listOf(
                                FixtureInfoItem(
                                    id = 1,
                                    firstTeam = FixtureTeam(
                                        id = 1,
                                        name = "Manchester United",
                                        score = 1
                                    ),
                                    secondTeam = FixtureTeam(
                                        id = 10,
                                        name = "Arsenal",
                                        score = 3
                                    ),
                                    time = "",
                                    attendance = 30000,
                                    status = "C"
                                ),
                                FixtureInfoItem(
                                    id = 1,
                                    firstTeam = FixtureTeam(
                                        id = 1,
                                        name = "Chelsea",
                                        score = 1
                                    ),
                                    secondTeam = FixtureTeam(
                                        id = 10,
                                        name = "Liverpool",
                                        score = 3
                                    ),
                                    time = "",
                                    attendance = 30000,
                                    status = "C"
                                )
                            )
                        )
                    )
                },
                navController = rememberNavController()
            )
        }
    }
}