package com.assignment.onlinescoreupdateapp.presentation.composables

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.assignment.onlinescoreupdateapp.domain.models.fixtures.FixtureInfoItem
import com.assignment.onlinescoreupdateapp.domain.models.fixtures.FixtureTeam
import com.example.compose.AppTheme

@Composable
fun FixtureList(fixtureList: List<FixtureInfoItem>, onFixtureClick: (FixtureInfoItem) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        LazyColumn {
            items(items = fixtureList, key = { item -> item.id }) {
                FixtureScoreItem(item = it, onClick = onFixtureClick)
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun EmployersListNightPreview() {
    AppTheme {
        Surface {
            FixtureList(
                fixtureList = listOf(
                    FixtureInfoItem(
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
                        id = 1,
                        time = "",
                        attendance = 30000,
                        status = "C"
                    ),
                    FixtureInfoItem(
                        firstTeam = FixtureTeam(
                            id = 1,
                            name = "Chelsea",
                            score = 1
                        ),
                        secondTeam = FixtureTeam(
                            id = 10,
                            name = "Southampton",
                            score = 1
                        ),
                        id = 1,
                        time = "",
                        attendance = 30000,
                        status = "C"
                    )
                ),
                onFixtureClick = {}
            )
        }
    }
}
