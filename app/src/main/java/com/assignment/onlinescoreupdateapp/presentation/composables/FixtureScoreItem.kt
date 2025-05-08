package com.assignment.onlinescoreupdateapp.presentation.composables

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.assignment.achmeaassignment.BuildConfig
import com.assignment.onlinescoreupdateapp.domain.models.fixtures.FixtureInfoItem
import com.assignment.onlinescoreupdateapp.domain.models.fixtures.FixtureTeam
import com.example.compose.AppTheme

@Composable
fun FixtureScoreItem(item: FixtureInfoItem, onClick: (item: FixtureInfoItem) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
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
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = item.firstTeam.name,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start
            )

            AsyncImage(
                model = "${BuildConfig.BASE_URL}blob/main/images/${item.firstTeam.id}",
                contentDescription = null,
                modifier = Modifier.width(40.dp)
            )

            Box(
                modifier = Modifier
                    .width(60.dp)
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(8.dp))
                    .background(
                        when (item.status) {
                            "C" -> Color.White
                            "I" -> Color.Red
                            else -> Color.Gray
                        }
                    )
            ) {
                Text(
                    text = "${item.firstTeam.score} - ${item.secondTeam.score}",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            }


            AsyncImage(
                model = "${BuildConfig.BASE_URL}blob/main/images/${item.secondTeam.id}",
                contentDescription = null,
                modifier = Modifier.width(40.dp)
            )


            Text(
                text = item.secondTeam.name,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
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