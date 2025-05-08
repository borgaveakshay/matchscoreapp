package com.assignment.onlinescoreupdateapp.domain.models.fixturedetails

data class MatchEvent(
    val minute: String,     // e.g., "42'"
    val scorerName: String, // e.g., "Saka"
    val teamAbbr: String,   // e.g., "ARS"
    val isOwnGoal: Boolean = false,
    val isPenalty: Boolean = false
)
