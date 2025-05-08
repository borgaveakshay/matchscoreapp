package com.assignment.onlinescoreupdateapp.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScoreBlock(score: String, halfTime: String) {
    Column(
        modifier = Modifier
            .background(Color(0xFF0033CC), shape = RoundedCornerShape(8.dp))
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(score, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(halfTime, color = Color.White, fontSize = 12.sp)
    }
}