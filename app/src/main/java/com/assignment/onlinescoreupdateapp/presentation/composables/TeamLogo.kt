package com.assignment.onlinescoreupdateapp.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.assignment.onlinescoreupdateapp.domain.models.fixturedetails.TeamScore

@Composable
fun TeamLogo(team: TeamScore) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        if (team.logoUrl != null) {
            AsyncImage(
                model = team.logoUrl,
                contentDescription = team.name,
                modifier = Modifier.size(40.dp)
            )
        }
        Text(team.abbr, fontWeight = FontWeight.Bold)
    }
}