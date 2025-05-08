package com.assignment.onlinescoreupdateapp.presentation.composables

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.assignment.onlinescoreupdateapp.domain.models.fixtures.FixtureInfoItem
import com.assignment.onlinescoreupdateapp.domain.models.fixtures.FixtureTeam
import com.example.compose.AppTheme

@Composable
fun FixtureScoreItem(item: FixtureInfoItem, onClick: (item: FixtureInfoItem) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onClick(item) },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = item.firstTeam.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun EmployerInfoItemNightPreview() {
    AppTheme {
        Surface {
            FixtureScoreItem(
                item = FixtureInfoItem(
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
                onClick = {}
            )
        }
    }
}