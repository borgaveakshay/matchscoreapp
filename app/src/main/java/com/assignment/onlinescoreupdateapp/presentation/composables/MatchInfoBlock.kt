package com.assignment.onlinescoreupdateapp.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import com.assignment.onlinescoreupdateapp.domain.models.fixturedetails.FixtureResult

@Composable
fun MatchInfoBlock(match: FixtureResult) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Kick Off: ${match.kickOffTime}", fontSize = 14.sp)
        Text(match.matchDate, fontSize = 14.sp)
        Text(match.stadium, fontSize = 14.sp)
        Text("Attendance: ${match.attendance}", fontSize = 14.sp)
        Text("Referee: ${match.referee}", fontSize = 14.sp)
    }
}