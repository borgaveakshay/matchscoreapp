package com.assignment.onlinescoreupdateapp.presentation.fixturedetails.ui

import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.assignment.onlinescoreupdateapp.domain.models.fixturedetails.FixtureResult
import com.assignment.onlinescoreupdateapp.domain.models.fixturedetails.MatchEvent
import com.assignment.onlinescoreupdateapp.domain.models.fixturedetails.TeamScore
import com.assignment.onlinescoreupdateapp.presentation.composables.MatchInfoBlock
import com.assignment.onlinescoreupdateapp.presentation.composables.ScoreBlock
import com.assignment.onlinescoreupdateapp.presentation.composables.TeamLogo
import com.assignment.onlinescoreupdateapp.presentation.fixturedetails.states.FixtureDetailsState
import com.assignment.onlinescoreupdateapp.presentation.fixturedetails.viewmodel.FixtureDetailsViewModel
import com.example.compose.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FixtureDetailsScreen(
    navController: NavController,
    matchState: State<FixtureDetailsState>,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Fixture Details",
                        style = MaterialTheme.typography.headlineSmall
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Default.ArrowBack, contentDescription = "Back")
                    }
                })
        },

        ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            when {
                matchState.value.isLoading -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }

                !matchState.value.error.isNullOrEmpty() -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = matchState.value.error ?: "Something went wrong",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }

                else -> {
                    matchState.value.fixtureDetails?.apply {
                        Text(
                            "${homeTeam.abbr} vs ${awayTeam.abbr}",
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                                .align(Alignment.CenterHorizontally),
                            fontWeight = FontWeight.Bold
                        )

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = 16.dp,
                                    vertical = 8.dp
                                ),
                            shape = RoundedCornerShape(12.dp),
                            elevation = CardDefaults.cardElevation(6.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(MaterialTheme.colorScheme.primaryContainer)
                                    .padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    TeamLogo(homeTeam)
                                    ScoreBlock(fullTimeScore, halfTimeScore)
                                    TeamLogo(awayTeam)
                                }

                                Spacer(Modifier.height(12.dp))

                                events.groupBy { it.teamAbbr }.forEach { (_, goals) ->
                                    goals.forEach {
                                        Text(
                                            text = "${it.minute}  Goal   ${it.scorerName}",
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.SemiBold,
                                            modifier = Modifier.padding(vertical = 2.dp)
                                        )
                                    }
                                }

                                Spacer(Modifier.height(12.dp))

                                MatchInfoBlock(this@apply)
                            }
                        }
                    }
                }
            }
        }
    }
    BackHandler {
        navController.popBackStack()
    }
}

@Composable
fun FixtureDetailsParent(
    navController: NavController,
    fixtureDetailsViewModel: FixtureDetailsViewModel = hiltViewModel(),
    fixtureId: Int // We can implement it to fetch particular fixture details
) {

    LaunchedEffect(Unit) {
        fixtureDetailsViewModel.getFixtureDetails(fixtureId)
    }
    FixtureDetailsScreen(
        navController = navController,
        matchState = fixtureDetailsViewModel.fixtureDetailsStateFlow.collectAsStateWithLifecycle()
    )
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun EmployerDetailsScreenPreview() {
    AppTheme {
        Surface {
            FixtureDetailsScreen(
                navController = NavController(LocalContext.current),
                matchState = remember {
                    mutableStateOf(
                        FixtureDetailsState(
                            fixtureDetails = FixtureResult(
                                awayTeam = TeamScore(
                                    name = "Away Team",
                                    abbr = "AT",
                                    logoUrl = "https://example.com/away-logo.png"
                                ),
                                homeTeam = TeamScore(
                                    name = "Home Team",
                                    abbr = "HT",
                                    logoUrl = null
                                ),
                                fullTimeScore = "2-1",
                                halfTimeScore = "1-0",
                                events = listOf(
                                    MatchEvent(
                                        minute = "45",
                                        scorerName = "Scorer Name",
                                        teamAbbr = "HT"
                                    ),
                                    MatchEvent(
                                        minute = "60",
                                        scorerName = "Another Scorer",
                                        teamAbbr = "AT"
                                    )
                                ),
                                kickOffTime = "20:00",
                                matchDate = "2023-08-15",
                                attendance = "5000",
                                referee = "Referee Name",
                                stadium = "Stadium Name"
                            ),
                            isLoading = false,
                            error = null
                        )
                    )
                }
            )
        }
    }
}

